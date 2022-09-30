package baseball.model;

import baseball.common.GameRule;

import java.util.HashSet;
import java.util.Set;

public class Guess {
    private String numbers;

    public Guess() {
    }

    public String getNumbers() {
        return this.numbers;
    }

    public void setNumbers(String numbers) {
        if (isValidNumbers(numbers)) {
            this.numbers = numbers;
        }
    }

    private boolean isValidNumbers(String numbers) {
        if (!isDigitNumbers(numbers) || isSameNumbers(numbers) || !isValidNumbersLength(numbers)) {
            return false;
        }

        return true;
    }

    private boolean isDigitNumbers(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            isDigit(numbers, i);
        }
        return true;
    }

    private boolean isDigit(String numbers, int index) {
        if (!Character.isDigit(numbers.charAt(index))) {
            throw new IllegalArgumentException();
        }
        return true;
    }

    private boolean isSameNumbers(String numbers) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < numbers.length(); i++) {
            set.add(numbers.charAt(i));
        }
        if (set.size() != numbers.length()) {
            throw new IllegalArgumentException();
        }
        return false;
    }

    private boolean isValidNumbersLength(String numbers) {
        if (numbers.length() != GameRule.NUMBERS_LENGTH.getValue()) {
            throw new IllegalArgumentException();
        }
        return true;
    }
}
