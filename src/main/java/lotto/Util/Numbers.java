package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Numbers {
    public static ArrayList<Integer> createNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            int number = Randoms.pickNumberInRange(1, 45);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
        return numbers;
    }
}
