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
        int testingNumber = 0;

        // When && Then
        assertThat(testingNumber).isEqualTo(GameRule.MIN_NUMBER.getValue());
    }

    @Test
    @DisplayName("GameRule - Max Number 테스트")
    void max_number_test() {
        // Given
        int testingNumber = 9;

        // When && Then
        assertThat(testingNumber).isEqualTo(GameRule.MAX_NUMBER.getValue());
    }

    @Test
    @DisplayName("GameRule - Game Restart 테스트")
    void game_restart_test() {
        // Given
        int testingResult = 1;

        // When && Then
        assertThat(testingResult).isEqualTo(GameRule.GAME_RESTART.getValue());
    }

    @Test
    @DisplayName("GameRule - Game End 테스트")
    void game_end_test() {
        // Given
        int testingResult = 2;

        // When && Then
        assertThat(testingResult).isEqualTo(GameRule.GAME_END.getValue());
    }

    @Test
    @DisplayName("스트링값으로 변환 테스트")
    void get_string_value_test() {
        // Given
        String testingResult = "2";

        // When && Then
        assertThat(testingResult).isEqualTo(GameRule.GAME_END.getStringValue());
    }
}