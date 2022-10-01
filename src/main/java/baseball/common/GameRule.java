package baseball.common;

public enum GameRule {
    NUMBERS_LENGTH(3),
    MIN_NUMBER(0),
    MAX_NUMBER(9),
    ANSWER_NUMBER_LENGTH(3),
    GAME_RESTART(1),
    GAME_END(2);

    private final int value;

    GameRule(int valuer) {
        this.value = valuer;
    }

    public int getValue() {
        return this.value;
    }

    public String getStringValue() {
        return String.valueOf(this.value);
    }
}
