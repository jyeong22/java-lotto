package lotto.model;

import java.util.List;

public class BonusNumber {
    private static final int LOTTO_MINIMUM_NUM = 1;
    private static final int LOTTO_MAXIMUM_NUM = 45;
    private final int number;

    public BonusNumber(String stringNumber, List<Integer>winningNumber) {
        validate(stringNumber, winningNumber);
        number = stringToInt(stringNumber);
    }

    public int getNumber() {
        return number;
    }

    private void validate(String stringNumber, List<Integer>winningNumber) {
        if(isEmpty(stringNumber)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if(!isDigit(stringNumber)){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        else if (!isInRange(stringToInt(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
        }
        else if(isInWinningNumber(stringToInt(stringNumber), winningNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복됩니다.");
        }
    }

    private boolean isEmpty(String stringNumber) {
        return stringNumber == null || stringNumber.isBlank();
    }

    private boolean isDigit(String stringNumber) {
        return stringNumber.chars().allMatch(Character::isDigit);
    }

    private boolean isInRange(int num) {
        return num>=LOTTO_MINIMUM_NUM && num<=LOTTO_MAXIMUM_NUM;
    }

    private boolean isInWinningNumber(int stringToInt, List<Integer> winningNumber) {
        return winningNumber.contains(stringToInt);
    }

    private int stringToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }
}
