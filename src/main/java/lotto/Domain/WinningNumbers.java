package lotto.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private Number bonusNumber;
    public WinningNumbers(ArrayList<String> winningNumbers) {
        validate(winningNumbers);
        this.winningNumbers = winningNumbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
    private void validate(ArrayList<String> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("6개가 아님");
        }
        for (String winningNumber : winningNumbers) {
            if (!isNumeric(winningNumber)) {
                throw new IllegalArgumentException("숫자로만 이루어져있지 않음");
            }
            if (!isValidLottoNumber(winningNumber)) {
                throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
        if (isDouble(winningNumbers)) {
            throw new IllegalArgumentException("숫자가 중복됨");
        }
    }

    private static boolean isNumeric(String input) {
        return input.matches("\\d+");
    }
    private static boolean isValidLottoNumber(String input) {
        int num = Integer.parseInt(input);
        return num > 0 && num <= 45;
    }

    private boolean isDouble(List<String> input) {
        HashSet<String> numbersSet = new HashSet<>(input);
        return numbersSet.size() != input.size();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public void setBonusNumber(String number) {
        Number bonusNumber = new Number(number);
        if (this.winningNumbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("숫자가 중복됨");
        }
        this.bonusNumber = bonusNumber;
    }
}
