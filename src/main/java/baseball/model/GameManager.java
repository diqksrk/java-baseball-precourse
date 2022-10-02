package baseball.model;

import baseball.common.GameRule;

public class GameManager {

    public boolean isGameEnd(String command) {
        if (!isValid(command)) {
            throw new IllegalArgumentException();
        }

        if (isRestart(command)) {
            return false;
        }

        return true;
    }

    private boolean isValid(String command) {
        if (!command.equals(GameRule.GAME_RESTART.getStringValue()) && !command.equals(GameRule.GAME_END.getStringValue())
        ) {
            return false;
        }

        return true;
    }

    private boolean isRestart(String command) {
        if (command.equals(GameRule.GAME_RESTART.getStringValue())
        ) {
            return true;
        }

        return false;
    }
}
