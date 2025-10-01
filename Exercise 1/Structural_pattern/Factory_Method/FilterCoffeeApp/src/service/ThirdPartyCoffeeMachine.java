package service;

// Simulating a 3rd-party library
public class ThirdPartyCoffeeMachine {
    public double makeCoffee(String variety, int qty) {
        return switch (variety.toLowerCase()) {
            case "cappuccino" -> 100.0 * qty;
            case "latte" -> 90.0 * qty;
            default -> 0;
        };
    }
}
