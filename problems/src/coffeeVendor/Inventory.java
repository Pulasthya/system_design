package coffeeVendor;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> currInventory = new HashMap<>();
    private Integer threshold = 10;

    public synchronized void addIngredient(String ingredientName, Integer ingredientQuantity) {
        Integer newIngredientQuantity = currInventory.getOrDefault(ingredientName, 0) + ingredientQuantity;
        currInventory.put(ingredientName, newIngredientQuantity);
    }

    public synchronized boolean useIngredient(String ingredientName, Integer ingredientQuantity) {
        Integer curQuantity = currInventory.get(ingredientName);
        if (curQuantity < ingredientQuantity) {
            System.out.println("Insufficient quantity of " + ingredientName);
            return false;
        }
        curQuantity -= ingredientQuantity;
        currInventory.put(ingredientName, curQuantity);
        return true;
    }

    public synchronized void checkLowIngredients() {
        for (String ingredient: currInventory.keySet()) {
            if (currInventory.get(ingredient) < threshold) {
                System.out.println(ingredient + " is running low, please add more");
            }
        }
    }
}