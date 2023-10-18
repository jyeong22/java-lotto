package lotto.model;

import lotto.controller.Lotto;
import java.util.*;

public class Statistics {
    private static final int SPECIAL_CASE_NUMBER = 5;
    private Map<WinningPrice, Integer> winningMap = new HashMap<>(){{
        put(WinningPrice.firstPlace, 0);
        put(WinningPrice.secondPlace, 0);
        put(WinningPrice.thirdPlace, 0);
        put(WinningPrice.fourthPlace, 0);
        put(WinningPrice.fifthPlace, 0);
    }};
    private long reward = 0;

    public Statistics(final PurchaseLottos purchaseLottos,
                      final Lotto winningLotto, final BonusNumber bonusNumber){
        List<Lotto> purchaseLottoList = purchaseLottos.getPurchaseLottoList();
        for(Lotto purchaseLotto :  purchaseLottoList){
            int matchingCount = compareTwoLotto(purchaseLotto, winningLotto);
            boolean bonusValue = compareLottoAndBonus(matchingCount, purchaseLotto, bonusNumber);
            Optional<WinningPrice> winningPriceValue = findWinningPrice(matchingCount, bonusValue);
            if(winningPriceValue.isPresent()){
                WinningPrice winningPrice = winningPriceValue.get();
                winningMap.replace(winningPrice, winningMap.get(winningPrice)+1);
                reward+=winningPrice.getPrice();
            }
        }
    }

    public Map<WinningPrice, Integer> getWinningMap() {
        return winningMap;
    }

    public long getReward() {
        return reward;
    }

    private int compareTwoLotto(Lotto purchaseLotto, Lotto winningLotto) {
        return (int)purchaseLotto.getNumbers().stream()
                .filter(number -> winningLotto.getNumbers().contains(number))
                // 다른 방법
                // .filter(number -> winningLotto.getNumbers().stream().anyMatch(Predicate.isEqual(number)))
                .count();
    }

    private boolean compareLottoAndBonus(int matchingCount, Lotto purchaseLotto, BonusNumber bonusNumber) {
        if(matchingCount != SPECIAL_CASE_NUMBER){
            return false;
        }
        return purchaseLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private Optional<WinningPrice> findWinningPrice(int matchingCount,boolean bonusValue) {
        return WinningPrice.getWinningPrice(matchingCount, bonusValue);
    }
}
