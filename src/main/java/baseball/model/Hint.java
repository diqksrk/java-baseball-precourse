package baseball.model;

public class Hint {
    private int ball;
    private int strike;

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void addStrike() {
        this.strike += 1;
    }

    public void addBall() {
        this.ball += 1;
    }
}
