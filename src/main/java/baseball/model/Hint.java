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

    public boolean hasBall() {
        return this.ball > 0 ?  true : false;
    }

    public boolean hasStrike() {
        return this.strike > 0 ? true : false;
    }
}
