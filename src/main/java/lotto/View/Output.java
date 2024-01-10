package lotto.View;

import lotto.Constant.PrintMessage;
import lotto.Domain.Lotto;
import lotto.Domain.WinningResult;
import lotto.Constant.LottoPrize;

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

    public static void printResult(WinningResult winningResult) {
        System.out.println("\n당첨 통계\n---");
        printPrize(winningResult);
        printProfit(winningResult);
    }

    private static void printProfit(WinningResult winningResult) {
        String profit = String.format("%.1f", winningResult.getProfit());
        System.out.printf("총 수익률은 %s%%입니다.\n", profit);
    }

    private static void printPrize(WinningResult winningResult) {
        for (int i = 0; i < 5; i++) {
            LottoPrize prize = LottoPrize.values()[i];
            System.out.printf(getPrintMessage(prize),
                    prize.getMatchNumber(),
                    prize.getPrice(),
                    winningResult.getPrizeCount(prize));
        }
    }
    private static String getPrintMessage(LottoPrize prize) {
        if (prize == LottoPrize.SECOND) {
            return PrintMessage.SECOND_PRINT_MESSAGE.getMessage();
        }
        return PrintMessage.OTHER_PRINT_MESSAGE.getMessage();
    }
}
