package lotto.Domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers extends Lotto{
    private Number bonusNumber;
    public WinningNumbers(ArrayList<Integer> winningNumbers) {
        super(winningNumbers);
    }

    public void setBonusNumber(int number) {
        Number bonusNumber = new Number(number);
        if (numbers.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("숫자가 중복됨");
        }
        this.bonusNumber = bonusNumber;
    }

    public Number getBonusNumber() {
        return bonusNumber;
    }
}
