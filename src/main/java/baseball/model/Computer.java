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

    public Hint giveHint(Guess guess) {
        Hint hint = new Hint();

        countingStrike(guess, hint);
        countingBall(guess, hint);

        return hint;
    }

    private void countingStrike(Guess guess, Hint hint) {
        for (char number : guess.getNumbers().toCharArray()) {
            addIfStrike(guess, number, hint);
        }
    }

    private void addIfStrike(Guess guess, int number, Hint hint) {
        if (guess.getNumbers().indexOf(number) == answer.getNumbers().indexOf(number)) {
            hint.addStrike();
        }
    }

    private void countingBall(Guess guess, Hint hint) {
        for (char number : guess.getNumbers().toCharArray()) {
            addIfBall(guess, number, hint);
        }
    }

    private void addIfBall(Guess guess, char number, Hint hint) {
        if (answer.getNumbers().contains(Character.toString(number)) &&
            guess.getNumbers().indexOf(number) != answer.getNumbers().indexOf(number)) {
            hint.addBall();
        }
    }
}
