package lotto.model;

import java.util.List;

public class BonusNumber {

    private int number;

    public BonusNumber(String stringNumber, List<Integer>winningNumber) {
        validate(stringNumber, winningNumber);
        number = StringToInt(stringNumber);
    }

    private int StringToInt(String stringNumber) {
        return Integer.parseInt(stringNumber);
    }

    private void validate(String stringNumber, List<Integer>winningNumber) {

    }
}
