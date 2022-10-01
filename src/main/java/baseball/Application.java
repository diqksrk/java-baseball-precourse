package baseball;

import baseball.controller.BaseBallGameController;
import baseball.model.GameManager;
import baseball.view.GameReader;

public class Application {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        do {
            BaseBallGameController baseBallGameController = new BaseBallGameController();
            baseBallGameController.start();
        } while (!gameManager.isGameEnd(GameReader.read()));
    }
}
