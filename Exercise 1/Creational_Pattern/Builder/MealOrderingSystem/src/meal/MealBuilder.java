package meal;

public class MealBuilder {
    private final String name;            // required
    private String type = "Regular";      // optional
    private double price = 0.0;           // optional
    private String description = "No description"; // optional

    public MealBuilder(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Meal name cannot be empty.");
        }
        this.name = name;
    }

    public MealBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public MealBuilder setPrice(double price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative.");
        this.price = price;
        return this;
    }

    public MealBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public Meal build() {
        return new Meal(name, type, price, description);
    }
}
