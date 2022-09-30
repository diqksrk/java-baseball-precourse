package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    @DisplayName("정답 숫자들 사이즈 테스트")
    void answer_numbers_size_test() {
        // When
        computer.generateAnserNumbers();

        // Then
        assertThat(computer.getAnswer().length()).isEqualTo(3);
    }

    @Test
    @DisplayName("정답 숫자들이 각각 1부터 9까지의 숫자인지 확인 테스트")
    void is_answer_numbers_test() {
        // When
        computer.generateAnserNumbers();

        // Then
        for (int i = 0; i < computer.getAnswer().length(); i++) {
            assertThat(Character.getNumericValue(
                                                computer.getAnswer()
                                                        .getNumbers()
                                                        .charAt(i))
                                                ).isBetween(0, 9);
        }
    }

    @Test
    @DisplayName("정답 숫자들이 각기 다른지 확인하는 테스트")
    void is_answer_numbers_individual_different() {
        // Given
        int standardNumber = 0;
        int compareNumber = 0;

        // When
        computer.generateAnserNumbers();

        // Then
        for (int i = 0; i < computer.getAnswer().length() - 1; i++) {
            standardNumber = Character.getNumericValue(
                                                    computer.getAnswer()
                                                            .getNumbers()
                                                            .charAt(i)
                                                        );
            compareNumber = Character.getNumericValue(
                                                    computer.getAnswer()
                                                            .getNumbers()
                                                            .charAt(i + 1)
                                                    );

            assertThat(standardNumber).isNotEqualTo(compareNumber);
        }
    }
}