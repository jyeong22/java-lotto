package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningStatisticsTest {

    @DisplayName("로또 등수 개수 세기")
    @Test
    void countLottoPrize(){
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("1,2,3,4,5,6"));
            add(new Lotto("1,2,3,4,5,7"));
            add(new Lotto("1,2,3,4,5,8"));
            add(new Lotto("1,2,3,4,8,9"));
            add(new Lotto("1,2,3,8,9,10"));
        }};

        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        HashMap<WinningReward, Integer> result = new HashMap<>() {{
            put(WinningReward.SIX_SAME_REWARD, 1);
            put(WinningReward.FIVE_AND_BONUS_SAME_REWARD, 1);
            put(WinningReward.FIVE_SAME_REWARD, 1);
            put(WinningReward.FOUR_SAME_REWARD, 1);
            put(WinningReward.THREE_SAME_REWARD, 1);
            put(WinningReward.BLANK, 0);
        }};
        WinningStatistics winningStatistics = new WinningStatistics(lottos, lotto.getNumbers(), bonus, new PurchaseAmount("6000"));
        assertThat(winningStatistics.getRewardMap()).isEqualTo(result);
    }

    @DisplayName("로또 총 수익률 계산하기")
    @Test
    void calculateRateOfReturn() {
        List<Lotto> lottos = new ArrayList<>(){{
            add(new Lotto("8, 21, 23, 41, 42, 43"));
            add(new Lotto("3, 5, 11, 16, 32, 38"));
            add(new Lotto("7, 11, 16, 35, 36, 44"));
            add(new Lotto("1, 8, 11, 31, 41, 42"));
            add(new Lotto("13, 14, 16, 38, 42, 45"));
            add(new Lotto("7, 11, 30, 40, 42, 43"));
            add(new Lotto("2, 13, 22, 32, 38, 45"));
            add(new Lotto("1, 3, 5, 14, 22, 45"));
        }};
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        int bonus = 7;
        WinningStatistics winningStatistics = new WinningStatistics(lottos, lotto.getNumbers(), bonus, new PurchaseAmount("8000"));
        assertThat(winningStatistics.getRateOfReturn()).isEqualTo(62.5);
    }
}
