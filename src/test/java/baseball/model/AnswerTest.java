package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class AnswerTest {
    Answer answer;

    @BeforeEach
    void setUp() {
        answer = new Answer();
    }

    @Test
    @DisplayName("정답 숫자 사이즈 테스트")
    void answer_number_size_test() {
        // When
        answer.addAnswerNumber(3);

        // Then
        assertThat(answer.length()).isEqualTo(1);
    }

    @Test
    @DisplayName("정답 숫자가 1부터 9까지의 숫자인지 확인 테스트")
    void is_answer_number_test() {
        // When
        answer.addAnswerNumber(3);

        // Then
        for (int i = 0; i < answer.length(); i++) {
            assertThat(Character.getNumericValue(
                                            answer.getNumbers()
                                                    .charAt(i)
                                                )).isBetween(0, 9);
        }
    }
}