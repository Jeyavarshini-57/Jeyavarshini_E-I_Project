package service;

import model.Order;

public interface CoffeeService {
    Order placeOrder(String coffeeType, int quantity) throws Exception;
}
