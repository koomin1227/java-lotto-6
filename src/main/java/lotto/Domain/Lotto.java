package lotto.Domain;

import lotto.MatchingResult;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    protected final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("6개가 아님");
        }
        if (isDouble(numbers)) {
            throw new IllegalArgumentException("숫자가 중복됨");
        }
        numbers.forEach(Number::validate);
    }

    protected boolean isDouble(List<Integer> numbers) {
        HashSet<Integer> numbersSet = new HashSet<>(numbers);
        return numbersSet.size() != numbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public MatchingResult getMatchNumber(WinningNumbers winningNumbers) {
        int matchCount = 0;
        boolean isBonusMatch = this.numbers.contains(winningNumbers.getBonusNumber().getNumber());
        for (Integer number : this.numbers) {
            if (winningNumbers.getNumbers().contains(number)) {
                matchCount += 1;
            }
        }
        return new MatchingResult(matchCount, isBonusMatch);
    }

    // TODO: 추가 기능 구현
}
