package baseball.common;

import baseball.model.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessageUtilsTest {
    Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    @DisplayName("hint message 만드는 기능 테스트 - 3볼")
    void make_hint_output_message_test1() {
        // Given
        String result;

        // When
        for (int i = 0; i < GameRule.NUMBERS_LENGTH.getValue(); i++) {
            hint.addBall();
        }
        result = MessageUtils.makeOutputHintMessage(hint);

        // Then
        assertThat(result).isEqualTo("3볼");
    }

    @Test
    @DisplayName("hint message 만드는 기능 테스트 - 1볼 1스트라이크")
    void make_hint_output_message_test2() {
        // Given
        String result;

        // When
        hint.addBall();
        hint.addStrike();
        result = MessageUtils.makeOutputHintMessage(hint);

        // Then
        assertThat(result).isEqualTo("1볼 1스트라이크");
    }

    @Test
    @DisplayName("hint message 만드는 기능 테스트 - 3스트라이크")
    void make_hint_output_message_test3() {
        // Given
        String result;

        // When
        for (int i = 0; i < GameRule.NUMBERS_LENGTH.getValue(); i++) {
            hint.addStrike();
        }
        result = MessageUtils.makeOutputHintMessage(hint);

        // Then
        assertThat(result).isEqualTo("3스트라이크");
    }

    @Test
    @DisplayName("hint message 만드는 기능 테스트 - 낫싱")
    void make_hint_output_message_test4() {
        // Given
        String result;

        // When
        result = MessageUtils.makeOutputHintMessage(hint);

        // Then
        assertThat(result).isEqualTo("낫싱");
    }

    @Test
    @DisplayName("정답인지 결과 message 만드는 기능 테스트 - 정답")
    void make_answer_result_message_test() {
        // Given
        String result;

        // When
        for (int i = 0; i < GameRule.ANSWER_NUMBER_LENGTH.getValue(); i++) {
            hint.addStrike();
        }
        result = MessageUtils.makeResultMessage(hint);

        // Then
        assertThat(result).isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("정답인지 결과 message 만드는 기능 테스트 - 정답 아님")
    void make_no_answer_result_message_test() {
        // Given
        String result;

        // When
        hint.addStrike();
        result = MessageUtils.makeResultMessage(hint);

        // Then
        assertThat(result).isEqualTo("");
    }
}