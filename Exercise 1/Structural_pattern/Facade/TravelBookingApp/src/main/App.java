package main;

import facade.TravelFacade;
import util.InputUtil;
import exception.BookingException;
import util.LoggerUtil;

public class App {
    public static void main(String[] args) {
        TravelFacade travelFacade = new TravelFacade();

        boolean running = true;
        while (running) {
            System.out.println("\n--- Travel Booking Menu ---");
            System.out.println("1. Book Travel");
            System.out.println("2. Exit");

            int choice = InputUtil.getInt("Enter your choice: ", 1, 2);

            switch (choice) {
                case 1 -> {
                    try {
                        String from = InputUtil.getString("Enter source city: ");
                        String to = InputUtil.getString("Enter destination city: ");
                        String city = InputUtil.getString("Enter hotel/car city: ");
                        int nights = InputUtil.getInt("Enter number of hotel nights: ", 1, 30);
                        int days = InputUtil.getInt("Enter number of car rental days: ", 1, 30);

                        travelFacade.bookTravel(from, to, city, nights, days);
                        LoggerUtil.info("Travel booking completed successfully!");
                    } catch (BookingException e) {
                        LoggerUtil.error(e.getMessage());
                    } catch (Exception e) {
                        LoggerUtil.error("Unexpected error: " + e.getMessage());
                    }
                }
                case 2 -> running = false;
            }
        }

        LoggerUtil.info("Exiting Travel Booking System. Goodbye!");
    }
}
