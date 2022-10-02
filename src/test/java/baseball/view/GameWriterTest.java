package baseball.view;

import baseball.common.GameMessage;
import baseball.common.MessageUtils;
import baseball.model.Hint;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

class GameWriterTest {
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originOut = System.out;
    GameWriter gameWriter;

    @BeforeEach
    void setUp() {
        gameWriter = new GameWriter();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void after() {
        System.setOut(originOut);
    }

    @Test
    @DisplayName("숫자 질의문 출력 테스트")
    void number_inquire_write_test() {
        // When
        gameWriter.write(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage(), false);

        // Then
        assertThat(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage()).isEqualTo(outputStream.toString());
    }

    @Test
    @DisplayName("힌트 출력 테스트")
    void hint_write_test() {
        // Given
        Hint hint = new Hint();
        String result;

        // When
        result = "1볼 1스트라이크";

        hint.addStrike();
        hint.addBall();
        GameWriter.write(MessageUtils.makeOutputHintMessage(hint), true);

        // Then
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("정답문구 출력 테스트 - 정답일경우")
    void answer_write_test() {
        // Given
        Hint hint = new Hint();
        String result;

        // When
        result = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

        hint.addStrike();
        hint.addStrike();
        hint.addStrike();
        GameWriter.write(MessageUtils.makeResultMessage(hint), true);

        // Then
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("정답문구 출력 테스트 - 정답이 아닐 경우")
    void no_answer_write_test() {
        // Given
        Hint hint = new Hint();
        String result;

        // When
        result = "";

        hint.addStrike();
        GameWriter.write(MessageUtils.makeResultMessage(hint), true);

        // Then
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }

    @Test
    @DisplayName("게임 재시작 안내 문구 출력 테스트")
    void game_command_message_write_test() {
        // Given
        String result = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

        // When
        GameWriter.write(GameMessage.GAME_COMMAND_MESSAGE.getMessage(), true);

        // Then
        assertThat(result).isEqualTo(outputStream.toString().trim());
    }
}