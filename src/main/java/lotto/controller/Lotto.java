package lotto.controller;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_MINIMUM_NUM = 1;
    private static final int LOTTO_MAXIMUM_NUM = 45;
    private static final int LOTTO_SIZE = 6;
    private static final String COMMA = ",";
    private static final String SPACE = " ";
    private static final String BLANK = "";
    private final List<Integer> numbers;

    // purchaseLottos를 초기화할 때
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    // WinningLotto를 초기화할 때
    public Lotto(String stringNumber){
        validate(stringNumber);
        this.numbers = stringListToIntList(stringToStringList(stringNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if(!isSixElement(numbers)){
            throw new IllegalArgumentException("[ERROR] 6개의 숫자가 아닙니다.");
        }
        else if (!isInRange(numbers)){
            throw new IllegalArgumentException("[ERROR] 1부터 45사이의 숫자가 아닙니다.");
        }
        else if(!isDistinct(numbers)){
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        }
    }

    private void validate(String stringNumber) {
        if(isEmpty(stringNumber)){
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
        else if(!isDigit(stringToStringList(stringNumber))){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
        validate(stringListToIntList(stringToStringList(stringNumber)));
    }

    private boolean isEmpty(String stringNumber) {
        return stringNumber == null || stringNumber.isBlank();
    }

    private boolean isDigit(List<String> strList) {
        return strList.stream().allMatch(str -> str.chars().allMatch(Character::isDigit));
    }

    private boolean isSixElement(List<Integer> intList) {
        return intList.size() == LOTTO_SIZE;
    }

    private boolean isInRange(List<Integer> intList) {
        return intList.stream().allMatch(num -> num>=LOTTO_MINIMUM_NUM && num<=LOTTO_MAXIMUM_NUM);
    }

    private boolean isDistinct(List<Integer> intList) {
        return intList.stream().distinct().count() == LOTTO_SIZE;
    }

    private List<String> stringToStringList(String stringNumber) {
        return List.of(stringNumber.replace(SPACE,BLANK).split(COMMA));
    }

    private List<Integer> stringListToIntList(List<String> stringList) {
        return stringList.stream().map(value -> Integer.parseInt(value))
                .collect(Collectors.toList());
    }
}
