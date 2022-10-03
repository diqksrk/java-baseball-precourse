package baseball.model;

import baseball.common.GameRule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class HintTest {
    Hint hint;

    @BeforeEach
    void setUp() {
        hint = new Hint();
    }

    @Test
    @DisplayName("스트라이크가 1더해지는지 확인하는 테스트")
    void add_strike_test() {
        // Given
        int result;

        // when
        result = 1;
        hint.addStrike();

        // then
        assertThat(result).isEqualTo(hint.getStrike());
    }

    @Test
    @DisplayName("볼이 1더해지는지 확인하는 테스트")
    void add_ball_test() {
        // Given
        int result;

        // when
        result = 1;
        hint.addBall();

        // then
        assertThat(result).isEqualTo(hint.getBall());
    }

    @Test
    @DisplayName("볼이 존재하는지 확인하는 테스트")
    void has_ball_true_test() {
        // when
        hint.addBall();

        // then
        assertThat(hint.hasBall()).isTrue();
    }

    @Test
    @DisplayName("볼이 존재하지 않는지 확인하는 테스트")
    void has_ball_false_test() {
        // when && then
        assertThat(hint.hasBall()).isFalse();
    }

    @Test
    @DisplayName("스트라이크가 존재하는지 확인하는 테스트")
    void has_strike_true_test() {
        // when
        hint.addStrike();

        // then
        assertThat(hint.hasStrike()).isTrue();
    }

    @Test
    @DisplayName("스트라이크가 존재하지 않는지 확인하는 테스트")
    void has_strike_false_test() {
        // when && then
        assertThat(hint.hasStrike()).isFalse();
    }

    @Test
    @DisplayName("정답일경우, 정답을 확인하는 테스트")
    void is_answer_true_test() {
        // when
        for (int i = 0; i < GameRule.ANSWER_NUMBER_LENGTH.getValue(); i++) {
            hint.addStrike();
        }

        // then
        assertThat(hint.isAnswer()).isTrue();
    }

    @DisplayName("정답이 아닐경우, 정답을 확인하는 테스트")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(ints = {1, 2})
    void is_answer_false_test(int count) {
        Hint hint2 = new Hint();

        // when
        for (int i = 0; i < count; i++) {
            hint.addBall();
            hint2.addStrike();
        }

        // then
        assertThat(hint.isAnswer()).isFalse();
        assertThat(hint2.isAnswer()).isFalse();
    }
}