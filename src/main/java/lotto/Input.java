package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Input {
    public static int inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        validatePrice(input);
        return Integer.parseInt(input);
    }

    public static List<String> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    public static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static void printError(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }

    private static void validatePrice(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자로만 이루어져있지 않음");
        }
        if (!isDivisibleBy1000(input)) {
            throw new IllegalArgumentException("1000으로 나누어 떨어지지 않음");
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }

    private static boolean isDivisibleBy1000(String input) {
        int num = Integer.parseInt(input);
        return num % 1000 == 0;
    }
}
