package baseball.model;

import baseball.common.GameRule;

public class Computer {
    private Answer answer = new Answer();

    public Answer getAnswer() {
        return this.answer;
    }

    public void generateAnserNumbers() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while (answer.getNumbers().length() < GameRule.NUMBERS_LENGTH.getValue()) {
            answer.addAnswerNumber(randomNumberGenerator.generate());
        }
    }

    public void giveHint(Guess guess) {

    }
}
