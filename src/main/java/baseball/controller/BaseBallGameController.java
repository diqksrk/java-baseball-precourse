package baseball.controller;

import baseball.common.GameMessage;
import baseball.model.Computer;
import baseball.model.Guess;
import baseball.view.GameReader;
import baseball.view.GameWriter;

public class BaseBallGameController {
    Guess guess;
    Computer computer;

    public BaseBallGameController() {
        guess = new Guess();
        computer = new Computer();
    }

    public void start() {
        GameWriter.write(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage());
        guess.setNumbers(GameReader.read());

        computer.giveHint(guess);
    }
}
