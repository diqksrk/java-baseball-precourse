package baseball.model;

import baseball.common.message.ErrorMessage;
import baseball.common.GameRule;

public class GameManager {

    public boolean isGameEnd(String command) {
        if (!isValid(command)) {
            throw new IllegalArgumentException(ErrorMessage.COMMAND_INPUT_ERROR_MESSAGE.getMessage());
        }

        if (isRestart(command)) {
            return false;
        }

        return true;
    }

    private boolean isBlankCommand(String numbers) {
        if (numbers == null || numbers.trim().isEmpty()) {
            return true;
        }

        return false;
    }

    private boolean isValid(String command) {
        if (isBlankCommand(command) || !isCommandNumber(command)) {
            return false;
        }

        return true;
    }

    private boolean isCommandNumber(String command) {
        if ( !command.equals(GameRule.GAME_RESTART.getStringValue()) && !command.equals(GameRule.GAME_END.getStringValue() )
        ) {
            return false;
        }

        return true;
    }

    private boolean isRestart(String command) {
        if ( command.equals(GameRule.GAME_RESTART.getStringValue() )
        ) {
            return true;
        }

        return false;
    }
}
