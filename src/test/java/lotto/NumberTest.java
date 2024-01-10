package lotto;

import org.junit.jupiter.api.Test;
import lotto.Domain.Number;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;
public class NumberTest {
    @Test
    void 로또_범위가_아닌_경우_오류() {
        assertThatThrownBy(() -> new Number(50))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상범위인_경우() {
        int num = 40;
        Number number = new Number(num);
        assertThat(number.getNumber()).isEqualTo(num);
    }
}
