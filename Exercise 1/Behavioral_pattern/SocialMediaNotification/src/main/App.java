package main;

import model.User;
import observer.SocialMediaPlatform;
import service.NotificationService;
import util.InputUtil;
import util.LoggerUtil;

public class App {
    public static void main(String[] args) {
        LoggerUtil.info("Welcome to Social Media Notification System");

        SocialMediaPlatform platform = new SocialMediaPlatform();
        NotificationService service = new NotificationService(platform);

        boolean running = true;
        while (running) {
            LoggerUtil.info("\n--- MENU ---");
            System.out.println("1. Add User");
            System.out.println("2. Remove User");
            System.out.println("3. Post Notification");
            System.out.println("4. Exit");

            int choice = InputUtil.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> {
                    String username = InputUtil.getString("Enter username: ");
                    service.addUser(new User(username));
                }
                case 2 -> {
                    String username = InputUtil.getString("Enter username to remove: ");
                    service.removeUser(new User(username)); // new user with same username for equality
                }
                case 3 -> {
                    String message = InputUtil.getString("Enter notification message: ");
                    service.postNotification(message);
                }
                case 4 -> {
                    LoggerUtil.info("Exiting application...");
                    running = false;
                }
                default -> LoggerUtil.error("Invalid choice.");
            }
        }
    }
}
