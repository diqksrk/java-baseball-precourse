package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Answer {
    private List<Integer> numbers = new ArrayList<>();

    public void addAnswerNumber(int number) {
        if (isAnswerNumber(number)) {
            this.numbers.add(number);
        }
    }

    public List getNumbers() {
        return this.numbers;
    }

    public int size() {
        return this.numbers.size();
    }

    private boolean isAnswerNumber(int number) {
        if (numbers.contains(number)) {
            return false;
        }

        return true;
    }
}
