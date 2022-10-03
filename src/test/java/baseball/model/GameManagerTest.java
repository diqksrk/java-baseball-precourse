package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameManagerTest {
    GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @DisplayName("게임 재시작, 종료 기능 테스트 - 잘못된 값 입력")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1234", "dsada", " &82"})
    @NullAndEmptySource
    void is_game_end_wrong_input(String input) {
        // Given
        String command = input;

        // Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> gameManager.isGameEnd(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("게임 재시작, 종료 기능 테스트 - 재시작")
    void is_game_end_restart() {
        // Given
        String command = "1";

        // When && Then
        assertThat(gameManager.isGameEnd(command)).isFalse();
    }

    @Test
    @DisplayName("게임 재시작, 종료 기능 테스트 - 종료")
    void is_game_end() {
        // Given
        String command = "2";

        // When && Then
        assertThat(gameManager.isGameEnd(command)).isTrue();
    }
}