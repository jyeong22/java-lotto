package lotto.model;

import java.util.Arrays;
import java.util.Optional;

public enum WinningPrice {

    firstPlace(2_000_000_000, 6 ),
    secondPlace(30_000_000, 5),
    thirdPlace(1_500_000, 5),
    fourthPlace(50_000, 4),
    fifthPlace(5_000, 3);

    final private long price;
    final private int matchingCount;
    static final private int MINIMUM_MATCHING_COUNT = 3;

    private WinningPrice(int price, int matchingCount){
        this.price = price;
        this.matchingCount = matchingCount;
    }

    public long getPrice() {
        return price;
    }

    public int getMatchingCount(){
        return matchingCount;
    }


    public static WinningPrice getWinningPrice(int matchingCount, boolean bonusMatch) {
        if (matchingCount == WinningPrice.secondPlace.getMatchingCount() && bonusMatch) {
            return WinningPrice.secondPlace;
        } else if (matchingCount == WinningPrice.thirdPlace.getMatchingCount() && !bonusMatch) {
            return WinningPrice.thirdPlace;
        }
        return Arrays.stream(WinningPrice.values())
                .filter(winningPrice -> matchingCount == winningPrice.getMatchingCount())
                .findAny().orElse(null);
    }
}
