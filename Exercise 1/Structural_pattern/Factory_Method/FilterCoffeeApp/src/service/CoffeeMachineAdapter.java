package service;

import exception.ValidationException;
import model.Coffee;
import model.Order;
import util.LoggerUtil;

public class CoffeeMachineAdapter implements CoffeeService {

    private final ThirdPartyCoffeeMachine thirdPartyMachine;

    public CoffeeMachineAdapter(ThirdPartyCoffeeMachine thirdPartyMachine) {
        this.thirdPartyMachine = thirdPartyMachine;
    }

    @Override
    public Order placeOrder(String coffeeType, int quantity) throws ValidationException {
        if (quantity <= 0)
            throw new ValidationException("Quantity must be positive");
        double total = thirdPartyMachine.makeCoffee(coffeeType, quantity);
        if (total == 0)
            throw new ValidationException("Unsupported coffee type: " + coffeeType);
        LoggerUtil.info("Order placed via 3rd party machine for " + coffeeType);
        return new Order(new Coffee(coffeeType, total / quantity), quantity);
    }
}
