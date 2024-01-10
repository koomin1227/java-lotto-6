package lotto;

import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.Domain.WinningNumbers;
import lotto.Util.Parser;
import lotto.View.Input;
import lotto.View.Output;

import java.util.ArrayList;

public class LottoController {
    private LottoMachine lottoMachine;
    private WinningNumbers winningNumbers;
    public void run() {
        createLottoCount();
        createLotto();
        createWinningNumbers();
        createBonusNumber();
    }

    private void createLotto() {
        ArrayList<Lotto> lottos = lottoMachine.publishLotto();
        Output.printLotto(lottos);
    }

    private void createLottoCount() {
        while (true) {
            try {
                int price = Input.inputPrice();
                this.lottoMachine = new LottoMachine(price);
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }

    private void createWinningNumbers() {
        while (true) {
            try {
                ArrayList<String> inputs = Input.inputWinningNumbers();
                this.winningNumbers = new WinningNumbers(Parser.parseIntList(inputs));
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
                this.winningNumbers.setBonusNumber(Parser.parseInt(input));
                return;
            } catch (IllegalArgumentException e) {
                Output.printError(e.getMessage());
            }
        }
    }
}
