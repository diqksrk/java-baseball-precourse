package baseball.controller;

import baseball.common.message.GameMessage;
import baseball.model.Guess;
import baseball.view.GameReader;
import baseball.view.GameWriter;

public class BaseBallGameController {
    Guess guess;

    public BaseBallGameController() {
        guess = new Guess();
    }

    public void start() {
        GameWriter.write(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage());
        guess.setNumbers(GameReader.read());
    }
}
