package coffeeVendor;

import java.util.HashMap;

public class CoffeeVendor {
    private HashMap<String, Coffee> coffeeTypes = new HashMap<>();
    private Payment payment = Payment.getInstance();
    private Inventory inventory = new Inventory();


    public CoffeeVendor() {}

    public synchronized boolean addCoffeeType(String coffeeName, Integer price, HashMap<String, Integer> ingredients) {
        if (coffeeTypes.containsKey(coffeeName)) {
            System.out.println("Cannot create a duplicate");
            return false;
        }
        Coffee coffee = new Coffee(coffeeName, ingredients, price);
        coffeeTypes.put(coffeeName, coffee);
        return true;
    }

    public synchronized void getCoffeeTypes() {
        for (String coffeeName: coffeeTypes.keySet()) {
            Integer price = coffeeTypes.get(coffeeName).getPrice();
            System.out.println(coffeeName + ": " + price);
        }
    }

    public synchronized boolean updateInventory(String ingredientName, Integer ingredientQuantity) {
        inventory.addIngredient(ingredientName, ingredientQuantity);
        return true;
    }

    public synchronized boolean makeCoffeeAndPayment(String coffeeName, Integer depositValue) {
        Coffee coffeeType = coffeeTypes.get(coffeeName);
        if (depositValue < coffeeType.getPrice()) {
            System.out.println("Insufficient funds provided");
            return false;
        }
        HashMap<String, Integer> requiredIngredients = coffeeType.getIngredients();
        for (String ingredientName: requiredIngredients.keySet()) {
            Integer ingredientQuantity = requiredIngredients.get(ingredientName);
            inventory.useIngredient(ingredientName, ingredientQuantity);
        }
        Integer change = payment.depositAmount(coffeeType.getPrice(), depositValue);
        System.out.println("Change has been issued: " + change);
        System.out.println("Enjoy your " + coffeeName);
        return true;
    }

    public synchronized void getPayments() {
        System.out.println(payment.getTransactions());
    }

    public synchronized void checkInventory() {
//        System.out.println("In checkInventory");
        synchronized (inventory) {
//            System.out.println("Done with synchronisation");
            inventory.checkLowIngredients();
        }
//        System.out.println("Exiting checkInventory");
    }
}