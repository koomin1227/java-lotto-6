package lotto;

import lotto.Domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {
    @Test
    void 숫자가_아닌_문자가_있는_경우_오류() {
        String[] input = {"12", "8", "a123", "3", "5", "35"};
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자의_범위가_넘는_경우_오류() {
        String[] input = {"12", "8", "50", "3", "5", "35"};
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복되는_경우_오류() {
        String[] input = {"12", "8", "12", "3", "5", "35"};
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_반환() {
        String[] input = {"12", "8", "45", "3", "5", "35"};
        ArrayList<String> inputs = new ArrayList<>(Arrays.asList(input));
        WinningNumbers winningNumbers = new WinningNumbers(inputs);
        assertThat(winningNumbers.getWinningNumbers().size()).isEqualTo(6);
    }
}
