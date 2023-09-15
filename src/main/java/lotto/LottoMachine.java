package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int lotto_game_start_number = 1;
    private static final int lotto_game_end_number = 45;
    private static final int lott_game_number_count = 6;
    private final List<Integer> randomNumbers;

    public LottoMachine(){
        this.randomNumbers = sortRandomNumbers(generateRandomNumbers());
    }

    private List<Integer> sortRandomNumbers(List<Integer> randomNumbers) {
        return randomNumbers.stream().sorted().collect(Collectors.toList());
    }

    public List<Integer> getRandomNumbers(){
        return randomNumbers;
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(lotto_game_start_number, lotto_game_end_number, lott_game_number_count);
    }
}
