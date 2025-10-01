package main;

import exception.AppException;
import model.Order;
import service.*;
import util.InputUtil;
import util.LoggerUtil;

public class App {

    public static void main(String[] args) {
        LoggerUtil.info("Welcome to Filter Coffee App!");
        CoffeeService filterService = new FilterCoffeeService();
        CoffeeService thirdPartyService = new CoffeeMachineAdapter(new ThirdPartyCoffeeMachine());

        boolean running = true;
        while (running) {
            try {
                LoggerUtil.info("\n1. Filter Coffee\n2. Third Party Machine\n3. Exit");
                int choice = InputUtil.readInt("Enter choice: ");
                switch (choice) {
                    case 1 -> handleOrder(filterService);
                    case 2 -> handleOrder(thirdPartyService);
                    case 3 -> { running = false; LoggerUtil.info("Thank you! Goodbye."); }
                    default -> LoggerUtil.error("Invalid option.");
                }
            } catch (AppException e) {
                LoggerUtil.error("Error: " + e.getMessage());
            } catch (Exception e) {
                LoggerUtil.error("Unexpected Error: " + e);
            }
        }
    }

    private static void handleOrder(CoffeeService service) throws Exception {
    String type = InputUtil.readString("Enter coffee type: ");
    int qty = InputUtil.readInt("Enter quantity: ");
    Order order = service.placeOrder(type, qty);
    LoggerUtil.info("Order Summary: " + order);
}

}
