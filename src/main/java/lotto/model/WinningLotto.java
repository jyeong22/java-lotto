package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinningLotto {

    private List<Integer> winningLottoNumber;

    public WinningLotto(String stringNumber){
        validate(stringNumber);
        winningLottoNumber = intStreamToList(stringToIntStream(stringNumber));
    }

    private List<Integer> intStreamToList(Stream<Integer> intStream) {
        return intStream.collect(Collectors.toList());
    }

    private void validate(String stringNumber) {
        if(isEmpty(stringNumber)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if(!isSixElement(stringToStrArray(stringNumber))|| isNotNumber(stringToStrArray(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
        else if (!isInRange(stringToIntStream(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
        }
        else if(!isDistinct(stringToIntStream(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }

    }

    private boolean isEmpty(String stringNumber) {
        return stringNumber.isBlank();
    }

    private boolean isSixElement(String[] splitByComma) {
        return splitByComma.length == 6;
    }

    private String[] stringToStrArray(String stringNumber) {
        return stringNumber.replace(" ","").split(",");
    }

    private boolean isNotNumber(String[] splitByComma) {
        try{
            for(String str:splitByComma){
                Integer.parseInt(str);
            }
            return false;
        }
        catch (Exception e){
            return true;
        }
    }

    private boolean isInRange(Stream<Integer> intStream) {
        return intStream.allMatch(num->num>=1 && num<=45);
    }

    private boolean isDistinct(Stream<Integer> intStream) {
        return intStream.distinct().count() == 6;
    }

    private Stream<Integer> stringToIntStream(String stringNumber) {
        return Arrays.stream(stringToStrArray(stringNumber)).map(str -> Integer.parseInt(str));
    }

    public List<Integer> getWinningLottoNumber() {
        return winningLottoNumber;
    }
}
