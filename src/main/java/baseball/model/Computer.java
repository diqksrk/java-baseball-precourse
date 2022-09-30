package baseball.model;

import baseball.common.GameRule;

public class Computer {
    Answer answer = new Answer();

    public Answer getAnswer() {
        return this.answer;
    }

    public void generateAnserNumbers() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while (answer.size() < GameRule.NUMBERS_LENGTH.getValue()) {
            answer.addAnswerNumber(randomNumberGenerator.generate());
        }
    }
}
