package baseball.common;

public enum GameRule {
    NUMBERS_LENGTH(3),
    MIN_NUMBER(0),
    MAX_NUMBER(9);

    private final int value;

    GameRule(int valuer) {
        this.value = valuer;
    }

    public int getValue() {
        return this.value;
    }
}
