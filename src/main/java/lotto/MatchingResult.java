package lotto;

public class MatchingResult {
    private int matchedCount;
    private boolean isBonusMatch;
    public MatchingResult(int matchedCount, boolean isBonusMatch) {
        this.matchedCount = matchedCount;
        this.isBonusMatch = isBonusMatch;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatch() {
        return isBonusMatch;
    }
}
