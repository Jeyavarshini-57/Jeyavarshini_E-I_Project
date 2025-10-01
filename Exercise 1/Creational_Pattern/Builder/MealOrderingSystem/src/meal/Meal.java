package meal;

public class Meal {
    private final String name;
    private final String type;
    private final double price;
    private final String description;

    // Constructor is now package-private, only builder can call
    Meal(String name, String type, double price, String description) {
        this.name = name;
        this.type = type;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void showDetails() {
        System.out.println("Meal: " + name);
        System.out.println("Type: " + type);
        System.out.println("Price: $" + price);
        System.out.println("Description: " + description);
        System.out.println("------------------------");
    }
}
