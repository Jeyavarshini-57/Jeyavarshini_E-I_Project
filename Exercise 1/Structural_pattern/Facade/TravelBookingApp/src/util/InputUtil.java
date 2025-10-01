package util;

import java.util.Scanner;

public class InputUtil {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt, int min, int max) {
        int input;
        while (true) {
            System.out.print(prompt);
            try {
                input = Integer.parseInt(scanner.nextLine());
                if(input < min || input > max) {
                    LoggerUtil.error("Input out of range. Please try again.");
                } else {
                    return input;
                }
            } catch (NumberFormatException e) {
                LoggerUtil.error("Invalid input. Enter a number.");
            }
        }
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
