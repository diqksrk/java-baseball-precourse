package baseball.view;

import baseball.common.message.GameMessage;
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
    @DisplayName("출력 테스트")
    void write_test() {
        // When
        gameWriter.write(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage());

        // Then
        assertThat(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage()).isEqualTo(outputStream.toString());
    }

}