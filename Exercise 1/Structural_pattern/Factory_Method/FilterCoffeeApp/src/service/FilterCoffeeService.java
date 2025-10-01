package service;

import exception.ValidationException;
import model.Coffee;
import model.Order;
import util.LoggerUtil;

public class FilterCoffeeService implements CoffeeService {

    @Override
    public Order placeOrder(String coffeeType, int quantity) throws ValidationException {
        validate(coffeeType, quantity);
        double price = switch (coffeeType.toLowerCase()) {
            case "filter" -> 50.0;
            case "espresso" -> 80.0;
            default -> throw new ValidationException("Unsupported coffee type: " + coffeeType);
        };
        LoggerUtil.info("Order placed for " + coffeeType + " x " + quantity);
        return new Order(new Coffee(coffeeType, price), quantity);
    }

    private void validate(String type, int qty) throws ValidationException {
        if (type == null || type.isBlank())
            throw new ValidationException("Coffee type cannot be empty");
        if (qty <= 0)
            throw new ValidationException("Quantity must be positive");
    }
}
