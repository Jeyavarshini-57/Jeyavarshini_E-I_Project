package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    // Read a non-empty string from user
    public static String readString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty. Please try again.");
            return readString(prompt);
        }
        return input;
    }

    // Read an integer from user with validation
    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return readInt(prompt);
        }
    }
}
