package baseball.common;

import baseball.model.Hint;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MessgeUtilsTest {
    Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    @DisplayName("hint message 만드는 기능 테스트 - 3볼")
    void make_output_message_test1() {
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
    void make_output_message_test2() {
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
    void make_output_message_test3() {
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
    void make_output_message_test4() {
        // Given
        String result;

        // When
        result = MessageUtils.makeOutputHintMessage(hint);

        // Then
        assertThat(result).isEqualTo("낫싱");
    }
}