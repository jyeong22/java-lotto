package lotto.model;

import java.util.List;

public class BonusNumber {

    private int number;

    public BonusNumber(String stringNumber, List<Integer>winningNumber) {
        validate(stringNumber, winningNumber);
        number = stringToInt(stringNumber);
    }

    private int stringToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    private void validate(String stringNumber, List<Integer>winningNumber) {
        if(isEmpty(stringNumber)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if (!isInRange(stringToInt(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
        }
        else if(isInWinningNumber(stringToInt(stringNumber), winningNumber)){
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복됩니다.");
        }
    }

    private boolean isInWinningNumber(int stringToInt, List<Integer> winningNumber) {
        return winningNumber.contains(stringToInt);
    }

    private boolean isInRange(int num) {
        return num>=1 && num<=45;
    }

    private boolean isEmpty(String stringNumber) {
        return stringNumber.isBlank();
    }

    public int getNumber() {
        return number;
    }
}
