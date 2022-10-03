package baseball.common;

import baseball.common.message.GameMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameMessageTest {

    @Test
    @DisplayName("숫자 질의 메시지 테스트")
    void number_inquire_message_test() {
        // Given
        String testingString = "숫자를 입력해주세요 : ";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("볼 문자 확인 테스트")
    void ball_message_test() {
        // Given
        String testingString = "볼";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.BALL.getMessage());
    }

    @Test
    @DisplayName("스트리이크 문자 확인 테스트")
    void strike_message_test() {
        // Given
        String testingString = "스트라이크";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.STRIKE.getMessage());
    }

    @Test
    @DisplayName("낫싱 문자 확인 테스트")
    void nothing_message_test() {
        // Given
        String testingString = "낫싱";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.NOTHING.getMessage());
    }

    @Test
    @DisplayName("정답 안내 메시지 테스트")
    void number_is_answer_message_test() {
        // Given
        String testingString = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.NUMBER_IS_ANSWER_MESSAGE.getMessage());
    }

    @Test
    @DisplayName("게임 종료 후 커멘드 메시지 테스트")
    void game_command_message_test() {
        // Given
        String testingString = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        // When && Then
        assertThat(testingString).isEqualTo(GameMessage.GAME_COMMAND_MESSAGE.getMessage());
    }
}