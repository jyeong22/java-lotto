package lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class WinningStatistics {
    private HashMap<WinningReward, Integer> rewardMap= new HashMap<>();
    private double rateOfReturn = 0;
    private double totalPrizeMoney = 0;

    WinningStatistics(List<Lotto> lottos,
                      List<Integer>winningLotto, int bonusNumber, PurchaseAmount purchaseAmount) {
        initialize();
        calcWinningStatistics(lottos, winningLotto, bonusNumber);
        calcRateOfReturn(purchaseAmount);
    }

    private void initialize() {
        rewardMap.put(WinningReward.THREE_SAME_REWARD, 0);
        rewardMap.put(WinningReward.FOUR_SAME_REWARD, 0);
        rewardMap.put(WinningReward.FIVE_SAME_REWARD, 0);
        rewardMap.put(WinningReward.FIVE_AND_BONUS_SAME_REWARD, 0);
        rewardMap.put(WinningReward.SIX_SAME_REWARD, 0);
        rewardMap.put(WinningReward.BLANK, 0);
    }

    public HashMap<WinningReward, Integer> getRewardMap() {
        return rewardMap;
    }

    private void calcRateOfReturn(PurchaseAmount purchaseAmount) {
        int amount = purchaseAmount.getAmount();
        rateOfReturn = totalPrizeMoney/amount * 100;
    }

    public double getRateOfReturn() {
        return Double.parseDouble(String.format("%.1f", rateOfReturn));
    }

    private void calcWinningStatistics(List<Lotto> lottos,
                                       List<Integer>winningLotto, int bonusNumber) {

        for(Lotto lotto : lottos){
            int sameComponentCnt = (int)lotto.getNumbers().stream()
                    .filter(number -> winningLotto.stream().anyMatch(Predicate.isEqual(number)))
                    .count();
            boolean isBonusInLotto = IsBonusInLotto(bonusNumber, lotto.getNumbers());
            calcTotalResult(sameComponentCnt, isBonusInLotto);
        }
    }

    private void calcTotalResult(int sameComponentCnt, boolean isBonusInLotto) {
        Optional<WinningReward> winningReward = WinningReward.getWinningRewardType(sameComponentCnt, isBonusInLotto);
        rewardMap.put(winningReward.get(), rewardMap.get(winningReward.get())+1);
        totalPrizeMoney+= winningReward.get().getReward();
    }

    private boolean IsBonusInLotto(int bonusNumber, List<Integer> lotto) {
        return lotto.contains(bonusNumber);

    }
}
