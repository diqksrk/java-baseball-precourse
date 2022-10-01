package baseball.view;

import baseball.common.GameMessage;
import baseball.common.MessageUtils;
import baseball.model.Hint;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;

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
        result = "1볼 1스트라이크" + "\r\n";
        hint.addStrike();
        hint.addBall();
        GameWriter.write(MessageUtils.makeOutputHintMessage(hint), true);

        // Then
        assertThat(result).isEqualTo(outputStream.toString());
    }
}