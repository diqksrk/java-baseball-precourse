package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ComputerTest {
    Computer computer;
    Guess guess;
    Hint hint;

    @BeforeEach
    void setUp() {
        computer = new Computer();
        guess = new Guess();
        Hint hint = new Hint();
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

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 3스트라이크")
    void give_hint_test1() {
        // Given
        String guessNumbers = "425";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(0);
        assertThat(hint.getStrike()).isEqualTo(3);
    }

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 2스트라이크 0볼")
    void give_hint_test2() {
        // Given
        String guessNumbers = "427";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(0);
        assertThat(hint.getStrike()).isEqualTo(2);
    }

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 1스트라이크 2볼")
    void give_hint_test3() {
        // Given
        String guessNumbers = "452";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(2);
        assertThat(hint.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 3볼")
    void give_hint_test4() {
        // Given
        String guessNumbers = "542";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(3);
        assertThat(hint.getStrike()).isEqualTo(0);
    }

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 1스트라이크 1볼")
    void give_hint_test5() {
        // Given
        String guessNumbers = "453";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(1);
        assertThat(hint.getStrike()).isEqualTo(1);
    }

    @Test
    @DisplayName("정확한 힌트를 주는지 테스트 - 낫싱")
    void give_hint_test6() {
        // Given
        String guessNumbers = "987";

        // When
        guess.setNumbers(guessNumbers);
        computer.getAnswer().addAnswerNumber(4);
        computer.getAnswer().addAnswerNumber(2);
        computer.getAnswer().addAnswerNumber(5);
        hint = computer.giveHint(guess);

        // Then
        assertThat(hint.getBall()).isEqualTo(0);
        assertThat(hint.getStrike()).isEqualTo(0);
    }
}