package lotto;

import java.util.Arrays;
import java.util.Optional;

public enum WinningReward {
    THREE_SAME_REWARD(3, 5_000),
    FOUR_SAME_REWARD(4, 50_000),
    FIVE_SAME_REWARD(5, 1_500_000),
    FIVE_AND_BONUS_SAME_REWARD(5, 30_000_000),
    SIX_SAME_REWARD(6, 2_000_000_000),
    BLANK(0, 0);

    private int cnt;
    private long reward;

    WinningReward(int cnt, long reward) {
        this.cnt = cnt;
        this.reward = reward;
    }

    public static Optional<WinningReward> getWinningRewardType(int sameComponentCnt, boolean isBonusInLotto) {
        int size = (int)Arrays.stream(WinningReward.values()).filter(winningReward -> sameComponentCnt == winningReward.getCnt()).count();
        if(size == 2){
            if(isBonusInLotto){
                return Optional.of(WinningReward.FIVE_AND_BONUS_SAME_REWARD);
            }
                return Optional.of(WinningReward.FIVE_SAME_REWARD);
        }
        else if (size == 1){
            return Arrays.stream(WinningReward.values()).filter(winningReward -> sameComponentCnt == winningReward.getCnt()).findAny();
        }
        return Optional.of(WinningReward.BLANK);
    }

    public int getCnt(){
        return cnt;
    }

    public long getReward(){
        return reward;
    }
}
