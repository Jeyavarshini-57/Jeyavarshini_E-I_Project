import ebook.*;
import util.*;

import java.util.*;

public class Main {

    private static final Map<String, EBook> ebookStore = new HashMap<>();

    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            System.out.println("\n--- Online E-Book Store ---");
            System.out.println("1. Create E-Book");
            System.out.println("2. Get E-Book by Title");
            System.out.println("3. Show All E-Books");
            System.out.println("4. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> createEBook();
                case 2 -> getEBook();
                case 3 -> showAllEBooks();
                case 4 -> {
                    run = false;
                    System.out.println("Exiting the program.");
                }
                default -> System.out.println("Invalid choice. Please enter 1-4.");
            }
        }
    }

    private static void createEBook() {
        try {
            String type = InputUtil.readString("Enter E-Book type (Fiction/Science/History): ");
            String title = InputUtil.readString("Enter title: ");
            if (ebookStore.containsKey(title)) {
                System.out.println("E-Book with this title already exists.");
                return;
            }
            String author = InputUtil.readString("Enter author: ");
            double price = InputUtil.readDouble("Enter price: ");

            EBook ebook = EBookFactory.createEBook(type, title, author, price);
            ebookStore.put(title, ebook);

            System.out.println("E-Book created successfully!");

        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error occurred.");
        }
    }

    private static void getEBook() {
        String title = InputUtil.readString("Enter title of the E-Book: ");
        EBook ebook = ebookStore.get(title);
        if (ebook != null) {
            ebook.showDetails();
        } else {
            System.out.println("E-Book not found.");
        }
    }

    private static void showAllEBooks() {
        if (ebookStore.isEmpty()) {
            System.out.println("No E-Books available.");
            return;
        }
        System.out.println("\n--- All E-Books ---");
        for (EBook ebook : ebookStore.values()) {
            ebook.showDetails();
        }
    }
}
