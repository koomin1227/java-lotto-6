package lotto;

public class LottoController {
    private int lottoCount = 0;
    public void run() {
        createLottoCount();
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
}
