package lotto;

public enum LottoPrize {
    FIRST(0, 2000000000, 6, false),
    SECOND(1, 30000000, 5, true),
    THIRD(2, 1500000, 5, false),
    FOURTH(3, 50000, 4, false),
    FIFTH(4, 5000, 3, false);

    private int value;
    private int prize;
    private int matchNumber;
    private boolean isBonusMatch;
    private LottoPrize(int value, int prize, int matchNumber, boolean isBonusMatch) {
        this.value = value;
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.isBonusMatch = isBonusMatch;
    }

    public int getValue() {
        return value;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public boolean getIsBonusMatch() {
        return isBonusMatch;
    }
}
