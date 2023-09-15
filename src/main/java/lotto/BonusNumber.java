package lotto;


public class BonusNumber {
    private final int bonusNumber;
    private static final int start_number = 1;
    private static final int end_number = 45;

    BonusNumber(Lotto lotto, String number){
        validate(lotto, number);
        this.bonusNumber = convertStringToInt(number);
    }

    private void validate(Lotto lotto, String number) {
        if(isEmpty(number)|| !isStringDigit(number)){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        }
        else if(!isInRange(convertStringToInt(number))){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_OUT_OF_RANGE.getMessage());
        }
        else if (isInWinningNumber(lotto, convertStringToInt(number))){
            throw new IllegalArgumentException(ExceptionMessage.BONUS_DUPLICATE_VALUE.getMessage());
        }
    }

    private boolean isEmpty(String number) {
        return number.isBlank();
    }

    private boolean isStringDigit(String number) {
        return number.chars().allMatch(Character::isDigit);
    }

    private boolean isInRange(int number) {
        return number>=start_number &&
                number<=end_number;
    }

    private boolean isInWinningNumber(Lotto lotto, int number) {
        return lotto.getNumbers().contains(number);
    }

    private int convertStringToInt(String number) {
        return Integer.parseInt(number);
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
