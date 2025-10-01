package util;

import java.util.Scanner;

public class InputUtil {

    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.print(prompt);
        String input = scanner.nextLine().trim();
        if (input.isEmpty()) {
            System.out.println("Input cannot be empty.");
            return readString(prompt);
        }
        return input;
    }

    public static double readDouble(String prompt) {
        System.out.print(prompt);
        try {
            double value = Double.parseDouble(scanner.nextLine());
            if (value < 0) throw new NumberFormatException();
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter a positive number.");
            return readDouble(prompt);
        }
    }

    public static int readInt(String prompt) {
        System.out.print(prompt);
        try {
            int value = Integer.parseInt(scanner.nextLine());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return readInt(prompt);
        }
    }
}
