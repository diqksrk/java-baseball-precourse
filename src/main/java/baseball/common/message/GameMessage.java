package baseball.common.message;

public enum GameMessage {
    NUMBER_INQUIRE_MESSAGE("숫자를 입력해주세요 : "),
    NUMBER_IS_ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_COMMAND_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
