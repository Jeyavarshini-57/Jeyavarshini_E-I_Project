package model;

public class Coffee {
    private final String type;
    private final double price;

    public Coffee(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() { return type; }
    public double getPrice() { return price; }

    @Override
    public String toString() {
        return "Coffee{" + "type='" + type + '\'' + ", price=" + price + '}';
    }
}
