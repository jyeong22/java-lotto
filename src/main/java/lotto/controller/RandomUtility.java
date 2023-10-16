package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomUtility {

    private static final int startNum = 1;
    private static final int endNum = 45;
    private static final int length = 6;

    public List<Integer> getRandomNumber(){
        return Randoms.pickUniqueNumbersInRange(startNum, endNum, length);
    }
}
