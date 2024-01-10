package lotto.Constant;

public enum LottoPrize {
    FIFTH(4, 5000, 3, "5,000"),
    FOURTH(3, 50000, 4, "50,000"),
    THIRD(2, 1500000, 5, "1,500,000"),
    SECOND(1, 30000000, 5, "30,000,000"),
    FIRST(0, 2000000000, 6, "2,000,000,000");

    private final int value;
    private final int prize;
    private final int matchNumber;
    private final String price;

    LottoPrize(int value, int prize, int matchNumber, String price) {
        this.value = value;
        this.prize = prize;
        this.matchNumber = matchNumber;
        this.price = price;
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

    public String getPrice() {
        return price;
    }
}
