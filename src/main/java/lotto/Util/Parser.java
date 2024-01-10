package lotto.Util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {
    public static int parseInt(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자로만 이루어져있지 않음");
        }
        return Integer.parseInt(input);
    }

    public static ArrayList<Integer> parseIntList(ArrayList<String> inputs) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String input : inputs) {
            numbers.add(parseInt(input));
        }
        return numbers;
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
}
