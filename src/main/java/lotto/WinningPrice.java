package lotto;

public enum WinningPrice {
    firstPlace(2_000_000_000, 6, false),
    secondPlace(30_000_000, 5, true),
    thirdPlace(1_500_000, 5, false),
    fourthPlace(50_000, 4, false),
    fifthPlace(5_000, 3, false);

    final private long price;
    final private int matchingCount;
    final private boolean bonusMatch;

    private WinningPrice(int price, int matchingCount, boolean bonusMatch){
        this.price = price;
        this.matchingCount = matchingCount;
        this.bonusMatch = bonusMatch;
    }

    public long getPrice() {
        return price;
    }

    public int getMatchingCount(){
        return matchingCount;
    }

    public boolean getBonusMatch(){
        return bonusMatch;
    }

}
