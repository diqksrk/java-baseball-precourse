package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {
    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("생성 숫자 범위 테스트")
    public void number_test() {
        // Given
        int randomNumber = 0;

        // When
        randomNumber = randomNumberGenerator.generate();

        // Then
        assertThat(randomNumber).isBetween(0, 9);
    }
}