package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        return SCANNER.nextLine().trim();
    }

    public static int readInt(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(SCANNER.nextLine().trim());
            } catch (NumberFormatException e) {
                LoggerUtil.error("Invalid number. Try again.");
            }
        }
    }
}
