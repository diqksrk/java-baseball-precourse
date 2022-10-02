package baseball.controller;

import baseball.common.GameMessage;
import baseball.common.MessageUtils;
import baseball.model.Computer;
import baseball.model.Guess;
import baseball.model.Hint;
import baseball.view.GameReader;
import baseball.view.GameWriter;

public class BaseBallGameController {
    Guess guess;
    Computer computer;
    Hint hint;

    public BaseBallGameController() {
        guess = new Guess();
        computer = new Computer();
        hint = new Hint();
    }

    public void start() {
        computer.generateAnserNumbers();

        roundStart();

        GameWriter.write(GameMessage.GAME_COMMAND_MESSAGE.getMessage(), true);
    }

    private void roundStart() {
        while (!hint.isAnswer()) {
            GameWriter.write(GameMessage.NUMBER_INQUIRE_MESSAGE.getMessage(), false);
            guess.setNumbers(GameReader.read());
            hint = computer.giveHint(guess);
            GameWriter.write(MessageUtils.makeOutputHintMessage(hint), true);
            GameWriter.write(MessageUtils.makeResultMessage(hint), true);
        }
    }
}
