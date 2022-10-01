package baseball.common;

import baseball.model.Hint;

public final class MessageUtils {
    static private StringBuilder stringBuilder = new StringBuilder();

    static private void init() {
        stringBuilder.setLength(0);
    }

    public static String makeOutputHintMessage(Hint hint) {
        init();

        makeBallMessage(hint, stringBuilder);
        makeStrikeMessage(hint, stringBuilder);
        makeNothingMessage(hint, stringBuilder);

        return stringBuilder.toString().trim();
    }

    public static String makeResultMessage(Hint hint) {
        init();

        if (!hint.isAnswer()) return "";

        stringBuilder.append(GameMessage.NUMBER_IS_ANSWER_MESSAGE.getMessage());
        return stringBuilder.toString();
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
