package baseball.model;

public class Answer {
    private StringBuilder numbers = new StringBuilder();

    public void addAnswerNumber(int number) {
        if (isAnswerNumber(number)) {
            this.numbers.append(String.valueOf(number));
        }
    }

    public String getNumbers() {
        return this.numbers.toString();
    }

    public int length() {
        return this.numbers.toString().length();
    }

    private boolean isAnswerNumber(int number) {
        if (numbers.toString().contains(String.valueOf(number))) {
            return false;
        }

        return true;
    }
}
