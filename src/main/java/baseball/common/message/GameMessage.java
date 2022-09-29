package baseball.common.message;

public enum  GameMessage {
    NUMBER_INQUIRE_MESSAGE("숫자를 입력해주세요 : ");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
