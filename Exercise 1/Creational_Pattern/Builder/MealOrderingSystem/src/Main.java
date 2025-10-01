import meal.Meal;
import meal.MealBuilder;
import util.InputUtil;

import java.util.*;

public class Main {

    private static final Map<String, Meal> mealMenu = new HashMap<>();

    public static void main(String[] args) {
        initializeMeals();

        boolean run = true;
        while (run) {
            System.out.println("\n--- Meal Ordering System ---");
            System.out.println("1. Show All Meals");
            System.out.println("2. Get Meal by Name");
            System.out.println("3. Exit");

            int choice = InputUtil.readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> showAllMeals();
                case 2 -> getMeal();
                case 3 -> {
                    run = false;
                    System.out.println("Exiting Meal Ordering System.");
                }
                default -> System.out.println("Invalid choice. Please enter 1-3.");
            }
        }
    }

    private static void initializeMeals() {
        Meal pizza = new MealBuilder("Pizza")
                .setType("Vegetarian")
                .setPrice(8.99)
                .setDescription("Cheese, Tomato, and Veggies")
                .build();

        Meal burger = new MealBuilder("Burger")
                .setType("Non-Vegetarian")
                .setPrice(6.49)
                .setDescription("Beef Patty with Lettuce and Tomato")
                .build();

        Meal pasta = new MealBuilder("Pasta")
                .setType("Vegetarian")
                .setPrice(7.25)
                .setDescription("Penne in Marinara Sauce")
                .build();

        mealMenu.put(pizza.getName(), pizza);
        mealMenu.put(burger.getName(), burger);
        mealMenu.put(pasta.getName(), pasta);
    }

    private static void showAllMeals() {
        if (mealMenu.isEmpty()) {
            System.out.println("No meals available.");
            return;
        }
        System.out.println("\n--- All Meals ---");
        for (Meal meal : mealMenu.values()) {
            meal.showDetails();
        }
    }

    private static void getMeal() {
        String name = InputUtil.readString("Enter meal name: ");
        Meal meal = mealMenu.get(name);
        if (meal != null) {
            meal.showDetails();
            System.out.println("Meal Delivered Successfully..!");
        } else {
            System.out.println("Meal not found.");
        }
    }
}
