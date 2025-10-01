package model;

public class Order {
    private final Coffee coffee;
    private final int quantity;

    public Order(Coffee coffee, int quantity) {
        this.coffee = coffee;
        this.quantity = quantity;
    }

    public double calculateTotal() {
        return coffee.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + " x " + coffee.getType() + " = ₹" + calculateTotal();
    }
}
