package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GuessTest {

    Guess guess;

    @BeforeEach
    void setUp() {
        this.guess = new Guess();
    }

    @DisplayName("숫자가 아닌 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"digit02", "digit", "$232dit", "23123digt"})
    void no_digit_number_test(String numbers) {
        // Given
        String str = numbers;

        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> guess.setNumbers(str))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("중복 숫자가 존재하는 경우 테스트")
    @ValueSource(strings = {"331", "112", "333"})
    void dupl_digit_number_test(String numbers) {
        // Given
        String str = numbers;

        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> guess.setNumbers(str))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("숫자 길이 테스트")
    @ValueSource(strings = {"1", "22"})
    void number_length_test(String numbers) {
        // Given
        String str = numbers;

        // When && Then
        assertSimpleTest(() ->
                assertThatThrownBy(() -> guess.setNumbers(str))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}