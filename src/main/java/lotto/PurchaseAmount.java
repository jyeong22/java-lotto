package lotto;

import java.util.stream.IntStream;

public class PurchaseAmount {
    private final int amount;
    private static final int ZERO = 0;
    private static final int THOUSAND_UNITS = 1000;
    private final int numberOfPurchasedAmount;

    PurchaseAmount(String amount){
        validate(amount);
        this.amount = Integer.parseInt(amount);
        this.numberOfPurchasedAmount = calculateNumber();
    }

    private int calculateNumber() {
        return amount/THOUSAND_UNITS;
    }

    private void validate(String amount) {
        if(isStringEmpty(amount)||!isStringDigit(amount)){
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_NUMBER.getMessage());
        }
        else if (!isExceedZero(amount)){
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_OVER_ZERO.getMessage());
        }
        else if(!isThousandUnits(amount)){
            throw new IllegalArgumentException(ExceptionMessage.PURCHASE_AMOUNT_IS_NOT_THOUSAND_UNIT.getMessage());
        }
    }

    private boolean isStringEmpty(String amount) {
        return amount.isBlank();
    }

    private boolean isStringDigit(String amount) {
        return amount.chars().allMatch(Character::isDigit);
    }

    private boolean isExceedZero(String amount) {
        return Integer.parseInt(amount)>ZERO;
    }

    private boolean isThousandUnits(String amount) {
        return Integer.parseInt(amount)%THOUSAND_UNITS == ZERO;
    }

    public int getAmount(){
        return amount;
    }

    public int getNumberOfPurchasedAmount(){
        return numberOfPurchasedAmount;
    }
}
