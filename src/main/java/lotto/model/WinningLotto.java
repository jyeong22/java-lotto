package lotto.model;

import java.util.List;

public class WinningLotto {

    private List<Integer> winningLottoNumber;

    public WinningLotto(String stringNumber){
        validate(stringNumber);
        winningLottoNumber = StringToList(stringNumber);
    }

    private List<Integer> StringToList(String stringNumber) {

    }

    private void validate(String stringNumber) {

    }
}
