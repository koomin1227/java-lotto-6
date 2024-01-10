package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.Number;
import lotto.Domain.Numbers;
import lotto.Domain.WinningNumbers;
import lotto.View.Input;
import lotto.View.Output;

import java.util.ArrayList;

public class LottoController {
    private int lottoCount = 0;
    private WinningNumbers winningNumbers;
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    public void run() {
        createLottoCount();
        createLotto();
        createWinningNumbers();
        createBonusNumber();
    }

    private void createLotto() {
        for (int i = 0; i < lottoCount; i++) {
            ArrayList<Integer> numbers = Numbers.createNumbers();
            lottos.add(new Lotto(numbers));
        }
        Output.printLotto(lottos);
    }

    private void createLottoCount() {
        while (true) {
            try {
                int price = Input.inputPrice();
                lottoCount = price / 1000;
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void createWinningNumbers() {
        while (true) {
            try {
                ArrayList<String> winningNumbers = Input.inputWinningNumbers();
                this.winningNumbers = new WinningNumbers(winningNumbers);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void createBonusNumber() {
        while (true) {
            try {
                String input = Input.inputBonusNumber();
                this.winningNumbers.setBonusNumber(input);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }
}
