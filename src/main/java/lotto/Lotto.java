package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    private static final String comma = ",";
    private static final int lotto_numbers_size = 6;
    private static final int lotto_game_start_number = 1;
    private static final int lotto_game_end_number = 45;
    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }
    public Lotto(String numbers){
        validateString(numbers);
        this.numbers = convertStringListToIntegerList(convertStringToList(numbers));
    }
    private void validateString(String numbers) {
        if(isEmptyString(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        }
        if(!isStringDigit(convertStringToList(numbers))){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        }
        validate(convertStringListToIntegerList(convertStringToList(numbers)));
    }
    private boolean isEmptyString(String numbers) {
        return numbers.isBlank();
    }
    private List<String> convertStringToList(String numbers) {

        return List.of(numbers.replace(" ", "").split(comma));
    }
    private boolean isStringDigit(List<String> numbers) {
        return numbers.stream().allMatch(number -> number.chars().allMatch(Character::isDigit));
    }
    private List<Integer> convertStringListToIntegerList(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(List<Integer> numbers) {
        if(!isSixNumbers(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_WRONG_NUMBER_OF_VALUE.getMessage());
        }
        else if (!isBetweenLottoRange(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_OUT_OF_RANGE.getMessage());
        }
        else if (isDuplicateNumber(numbers)){
            throw new IllegalArgumentException(ExceptionMessage.LOTTO_DUPLICATE_VALUE.getMessage());
        }
    }
    private boolean isDuplicateNumber(List<Integer> numbers) {
        return numbers.stream().distinct().count() != lotto_numbers_size;
    }
    private boolean isBetweenLottoRange(List<Integer> numbers) {
        return numbers.stream().allMatch(number -> number>=lotto_game_start_number && number<=lotto_game_end_number);
    }
    private boolean isSixNumbers(List<Integer> numbers) {
        return numbers.size() == lotto_numbers_size;
    }
    public List<Integer> getNumbers(){
        return numbers;
    }
}
