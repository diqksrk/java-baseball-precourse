package baseball.view;

public class GameWriter {
    public static void write(String str, boolean newLine) {
        if (str.trim().isEmpty()) return;

        if (newLine) {
            System.out.println(str);
            return;
        }

        System.out.print(str);
    }
}
