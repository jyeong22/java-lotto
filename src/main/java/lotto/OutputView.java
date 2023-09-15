package lotto;

import java.util.HashMap;
import java.util.List;

public class OutputView {
    private static final String NUMBER_OF_LOTTOS_PURCHASED_MESSAGE = "개를 구매했습니다.";

    public static void printNumberOfLottosPurchased(int numberOfLottosPurchased) {
        System.out.println(numberOfLottosPurchased + NUMBER_OF_LOTTOS_PURCHASED_MESSAGE);
    }

    public static void printLottosList(List<Lotto> lottos) {
        for (Lotto lotto: lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static void printWinningStatistics(WinningStatistics winningStatistics) {
        HashMap<WinningReward, Integer> rewardMap = winningStatistics.getRewardMap();
        System.out.println("3개 일치 (5,000원) - "+rewardMap.get(WinningReward.THREE_SAME_REWARD)+"개");
        System.out.println("4개 일치 (50,000원) - "+rewardMap.get(WinningReward.FOUR_SAME_REWARD)+"개");
        System.out.println("5개 일치 (1,500,000원) - "+rewardMap.get(WinningReward.FIVE_SAME_REWARD)+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+rewardMap.get(WinningReward.FIVE_AND_BONUS_SAME_REWARD)+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+rewardMap.get(WinningReward.SIX_SAME_REWARD)+"개");
    }

    public static void printRateOfReturn(WinningStatistics winningStatistics){
        System.out.println("총 수익률은 "+winningStatistics.getRateOfReturn()+"%입니다.");
    }
}
