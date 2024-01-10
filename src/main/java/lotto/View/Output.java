package lotto.View;

import lotto.Domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class Output {
    public static void printError(String message) {
        System.out.printf("[ERROR] %s\n", message);
    }

    public static void printLotto(ArrayList<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            printLottoNumber(lotto);
        }
    }

    private static void printLottoNumber(Lotto lotto) {
        StringBuilder output = new StringBuilder("[");
        List<Integer> numbers = lotto.getNumbers();
        numbers.forEach(number -> {
            output.append(number.toString()).append(", ");
        });
        output.setLength(output.length() - 2);
        output.append("]");
        System.out.println(output);
    }
}
