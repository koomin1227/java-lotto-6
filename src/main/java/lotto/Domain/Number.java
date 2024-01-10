package lotto.Domain;

public class Number {
    private final int number;
    public Number(int number) {
        validate(number);
        this.number = number;
    }

    public static void validate(int input) {
        if (!isValidLottoNumber(input)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isValidLottoNumber(int number) {
        return number > 0 && number <= 45;
    }

    public int getNumber() {
        return number;
    }
}
