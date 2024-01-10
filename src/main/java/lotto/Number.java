package lotto;

public class Number {
    private final int number;
    public Number(String input) {
        validate(input);
        this.number = Integer.parseInt(input);
    }

    private void validate(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자로만 이루어져있지 않음");
        }
        if (!isValidLottoNumber(input)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
    private static boolean isValidLottoNumber(String input) {
        int num = Integer.parseInt(input);
        return num > 0 && num <= 45;
    }

    public int getNumber() {
        return number;
    }
}
