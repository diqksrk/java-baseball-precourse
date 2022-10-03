package baseball.common.message;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {

    @Test
    @DisplayName("command 잘못 입력시 출력 메시지 테스트")
    void command_imput_error_message_test() {
        // Given
        String testingString = "1혹은 2를 입력해주세요.";

        // When && Then
        assertThat(testingString).isEqualTo(ErrorMessage.COMMAND_INPUT_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("빈값 입력시 출력 메시지 테스트")
    void blank_number_error_message_test() {
        // Given
        String testingString = "값이 비었습니다. 값을 입력해주세요.";

        // When && Then
        assertThat(testingString).isEqualTo(ErrorMessage.BLANK_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("숫자를 입력하지 않을시 출력 메시지 테스트")
    void digit_number_error_message_test() {
        // Given
        String testingString = "숫자를 입력해주세요.";

        // When && Then
        assertThat(testingString).isEqualTo(ErrorMessage.DIGIT_NUMBER_ERROR_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("3자리 숫자를 입력하지 않을시 출력 메시지 테스트")
    void nothing_message_test() {
        // Given
        String testingString = "3자리의 숫자를 입력해주세요.";

        // When && Then
        assertThat(testingString).isEqualTo(ErrorMessage.NUMBER_LENGTH_ERROR_MESSAGE.getMessage());
    }
}