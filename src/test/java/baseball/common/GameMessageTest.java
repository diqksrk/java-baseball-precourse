package baseball.common;

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

}