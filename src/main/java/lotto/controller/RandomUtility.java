package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;

public class RandomUtility {
    private static final int LOTTO_MINIMUM_NUM = 1;
    private static final int LOTTO_MAXIMUM_NUM = 45;
    private static final int LOTTO_SIZE = 6;

    public List<Integer> getRandomNumber(){
        List<Integer> randomList = generateRandomNumbers();
        // 오름차순 방법 1
         return randomList.stream()
                 .sorted()
                 .collect(Collectors.toList());
        // 오름차순 방법 2 - randomList는 수정이 불가하므로 오류 발생
        // Collections.sort(randomList);
    }

    private List<Integer> generateRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MINIMUM_NUM, LOTTO_MAXIMUM_NUM, LOTTO_SIZE);
    }
}
