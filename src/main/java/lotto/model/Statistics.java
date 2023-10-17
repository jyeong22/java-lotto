package lotto.model;

import lotto.WinningPrice;
import lotto.controller.Lotto;

import java.util.*;

public class Statistics {

    Map<WinningPrice, Integer> winningMap = new HashMap<>(){{
        put(WinningPrice.firstPlace, 0);
        put(WinningPrice.secondPlace, 0);
        put(WinningPrice.thirdPlace, 0);
        put(WinningPrice.fourthPlace, 0);
        put(WinningPrice.fifthPlace, 0);
    }};
    long reward = 0;


    public Statistics(final PurchaseLottos purchaseLottos,
                      final WinningLotto winningLotto, final BonusNumber bonusNumber){

        List<Lotto> purchaseLottoList = purchaseLottos.getPurchaseLottoList();

        for(Lotto purchaseLotto :  purchaseLottoList){
            int matchingCount = compareTwoLotto(purchaseLotto, winningLotto);
            Optional<WinningPrice> winningPriceValue = findWinningPrice(matchingCount, purchaseLotto, bonusNumber);
            if(winningPriceValue.isPresent()){
                WinningPrice winningPrice = winningPriceValue.get();
                winningMap.replace(winningPrice, winningMap.get(winningPrice)+1);
                reward+=winningPrice.getPrice();
            }
        }
    }

    private int compareTwoLotto(Lotto purchaseLotto, WinningLotto winningLotto) {
        return (int)purchaseLotto.getNumbers().stream()
                .filter(number -> winningLotto.getWinningLottoNumber().contains(number))
                .count();
    }

    private Optional<WinningPrice> findWinningPrice(int matchingCount,Lotto purchaseLotto, BonusNumber bonusNumber ) {

        if(matchingCount != 5){
            return Arrays.stream(WinningPrice.values())
                    .filter(wp -> matchingCount == wp.getMatchingCount())
                    .findAny();
        }

        boolean bonusValue = compareLottoAndBonus(purchaseLotto, bonusNumber);
        return Arrays.stream(WinningPrice.values())
                .filter(wp -> matchingCount == wp.getMatchingCount() && bonusValue == wp.getBonusMatch())
                .findAny();

    }

    private boolean compareLottoAndBonus(Lotto purchaseLotto, BonusNumber bonusNumber) {
        return purchaseLotto.getNumbers().contains(bonusNumber.getNumber());
    }

    public Map<WinningPrice, Integer> getWinningMap() {
        return winningMap;
    }

    public long getReward() {
        return reward;
    }
}
