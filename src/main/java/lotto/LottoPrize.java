package lotto;

public enum LottoPrize {
    FIFTH(4, 5000, 3),
    FOURTH(3, 50000, 4),
    THIRD(2, 1500000, 5),
    SECOND(1, 30000000, 5),
    FIRST(0, 2000000000, 6);

    private final int value;
    private final int prize;
    private final int matchNumber;

    LottoPrize(int value, int prize, int matchNumber) {
        this.value = value;
        this.prize = prize;
        this.matchNumber = matchNumber;
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
}
