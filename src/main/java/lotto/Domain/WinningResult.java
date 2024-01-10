package lotto.Domain;


import lotto.Constant.LottoPrize;

public class WinningResult {
    private final int[] result = new int[5];
    private final int price;
    private int totalProfit = 0;

    public WinningResult(int price) {
        this.price = price;
    }

    public void updateResult(MatchingResult matchingResult) {
        if (LottoPrize.FIRST.getMatchNumber() == matchingResult.getMatchedCount()) {
            result[LottoPrize.FIRST.getValue()] += 1;
            totalProfit += LottoPrize.FIRST.getPrize();
        }
        if (LottoPrize.SECOND.getMatchNumber() == matchingResult.getMatchedCount() && matchingResult.isBonusMatch()) {
            result[LottoPrize.SECOND.getValue()] += 1;
            totalProfit += LottoPrize.SECOND.getPrize();
        }
        if (LottoPrize.THIRD.getMatchNumber() == matchingResult.getMatchedCount()) {
            result[LottoPrize.THIRD.getValue()] += 1;
            totalProfit += LottoPrize.THIRD.getPrize();
        }
        if (LottoPrize.FOURTH.getMatchNumber() == matchingResult.getMatchedCount()) {
            result[LottoPrize.FOURTH.getValue()] += 1;
            totalProfit += LottoPrize.FOURTH.getPrize();
        }
        if (LottoPrize.FIFTH.getMatchNumber() == matchingResult.getMatchedCount()) {
            result[LottoPrize.FIFTH.getValue()] += 1;
            totalProfit += LottoPrize.FIFTH.getPrize();
        }
    }

    public int getPrizeCount(LottoPrize prize) {
        return result[prize.getValue()];
    }

    public double getProfit() {
        return ((double) totalProfit / price) * 100;
    }
}
