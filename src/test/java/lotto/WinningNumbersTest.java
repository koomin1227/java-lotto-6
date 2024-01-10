package lotto;

import lotto.Domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumbersTest {

    @Test
    void 숫자의_범위가_넘는_경우_오류() {
        Integer[] input = {1,2,3,4,5,50};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 중복되는_경우_오류() {
        Integer[] input = {1,2,3,4,5,5};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 개수가_6이_아닌_경우_오류() {
        Integer[] input = {1,2,3,4,5};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        assertThatThrownBy(() -> new WinningNumbers(inputs))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨번호_반환() {
        Integer[] input = {1,2,3,4,5,6};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        WinningNumbers winningNumbers = new WinningNumbers(inputs);
        assertThat(winningNumbers.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 보너스_번호의_범위가_넘는경우_오류() {
        Integer[] input = {1,2,3,4,5,6};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        WinningNumbers winningNumbers = new WinningNumbers(inputs);
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_중복되는_경우_오류() {
        Integer[] input = {1,2,3,4,5,6};
        ArrayList<Integer> inputs = new ArrayList<>(Arrays.asList(input));
        WinningNumbers winningNumbers = new WinningNumbers(inputs);
        assertThatThrownBy(() -> winningNumbers.setBonusNumber(1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
