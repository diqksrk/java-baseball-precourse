package baseball.common;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GameRuleTest {

    @Test
    @DisplayName("GameRule - 숫자 전체 길이 테스트")
    void numbers_length_test() {
        // Given
        int testingLength = 3;

        // When && Then
        assertThat(testingLength).isEqualTo(GameRule.NUMBERS_LENGTH.getValue());
    }

    @Test
    @DisplayName("GameRule - Min Number 테스트")
    void min_number_test() {
        // Given
        int testingLength = 0;

        // When && Then
        assertThat(testingLength).isEqualTo(GameRule.MIN_NUMBER.getValue());
    }

    @Test
    @DisplayName("GameRule - Ma Number 테스트")
    void max_number_test() {
        // Given
        int testingLength = 9;

        // When && Then
        assertThat(testingLength).isEqualTo(GameRule.MAX_NUMBER.getValue());
    }
}