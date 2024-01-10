package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private final ArrayList<Lotto> lottos = new ArrayList<>();
    private int price;
    private int count;

    public LottoMachine(int price) {
        this.price = price;
        this.count = price / 1000;
    }

    public ArrayList<Lotto> publishLotto() {
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    public WinningResult calculateWinningResults(WinningNumbers winningNumbers) {
        WinningResult result = new WinningResult(price);
        for(Lotto lotto:lottos) {
            MatchingResult matchResult = lotto.getMatchNumber(winningNumbers);
            result.updateResult(matchResult);
        }
        return result;
    }
}
