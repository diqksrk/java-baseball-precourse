package baseball.model;

public class Computer {
    Answer answer = new Answer();

    public Answer getAnswer() {
        return this.answer;
    }

    public void generateAnserNumbers() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        while (answer.size() < 3) {
            answer.addAnswerNumber(randomNumberGenerator.generate());
        }
    }
}
