package baseball.common;

import baseball.model.Hint;

public final class MessageUtils {

    public static String makeOutputHintMessage(Hint hint) {
        StringBuilder stringBuilder = new StringBuilder();

        makeBallMessage(hint, stringBuilder);
        makeStrikeMessage(hint, stringBuilder);
        makeNothingMessage(hint, stringBuilder);

        return stringBuilder.toString().trim();
    }

    private static void makeNothingMessage(Hint hint, StringBuilder stringBuilder) {
        if (!hint.hasStrike() && !hint.hasBall()) {
            stringBuilder.append(GameMessage.NOTHING.getMessage());
        }
    }

    private static void makeStrikeMessage(Hint hint, StringBuilder stringBuilder) {
        if (hint.hasStrike()) {
            stringBuilder.append(hint.getStrike() + GameMessage.STRIKE.getMessage() + " ");
        }
    }

    private static void makeBallMessage(Hint hint, StringBuilder stringBuilder) {
        if (hint.hasBall()) {
            stringBuilder.append(hint.getBall() + GameMessage.BALL.getMessage() + " ");
        }
    }
}
