package main;

import exception.VendingMachineException;
import model.Item;
import service.VendingMachine;
import util.InputUtil;
import util.LoggerUtil;

public class App {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // Load Items
        machine.addItem(1, new Item("Coke", 20, 5));
        machine.addItem(2, new Item("Pepsi", 25, 5));
        machine.addItem(3, new Item("Juice", 30, 3));

        LoggerUtil.info("Welcome to the Vending Machine!");

        boolean running = true;
        while (running) {
            try {
                machine.showItems();
                int choice = InputUtil.getInt(
                        "\nChoose option:\n1. Select Item\n2. Pay\n3. Exit\nEnter choice: ", 1, 3);

                switch (choice) {
                    case 1 -> {
                        int item = InputUtil.getInt("Enter item number: ", 1, 3);
                        machine.selectItem(item);
                    }
                    case 2 -> {
                        int amount = InputUtil.getInt("Enter amount: ", 1, 1000);
                        machine.insertMoney(amount);
                    }
                    case 3 -> {
                        LoggerUtil.info("Exiting... Thank you!");
                        running = false;
                    }
                }
            } catch (VendingMachineException e) {
                LoggerUtil.error(e.getMessage());
            } catch (Exception e) {
                LoggerUtil.error("Unexpected error: " + e.getMessage());
            }
        }
    }
}
