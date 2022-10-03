package baseball.common.message;

public enum ErrorMessage {
    COMMAND_INPUT_ERROR_MESSAGE("1혹은 2를 입력해주세요."),
    BLANK_NUMBER_ERROR_MESSAGE("값이 비었습니다. 값을 입력해주세요."),
    DIGIT_NUMBER_ERROR_MESSAGE("숫자를 입력해주세요."),
    NUMBER_LENGTH_ERROR_MESSAGE("3자리의 숫자를 입력해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
