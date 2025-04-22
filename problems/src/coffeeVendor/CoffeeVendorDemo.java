package coffeeVendor;

import java.util.HashMap;
import java.util.Scanner;

public class CoffeeVendorDemo {
    public static void run() {
        CoffeeVendor coffeeVendor = new CoffeeVendor();
        Scanner scanner = new Scanner(System.in);

        HashMap<String, Integer> ingredients = new HashMap<>();
        ingredients.put("Coffee", 15);
        ingredients.put("Milk", 15);
        ingredients.put("Sugar", 15);
        coffeeVendor.addCoffeeType("Filter Coffee", 30, ingredients);

        ingredients = new HashMap<>();
        ingredients.put("Coffee", 18);
        ingredients.put("Milk", 18);
        ingredients.put("Sugar", 18);
        coffeeVendor.addCoffeeType("Americano", 60, ingredients);

        coffeeVendor.updateInventory("Sugar", 20);
        coffeeVendor.updateInventory("Coffee", 20);
        coffeeVendor.updateInventory("Milk", 20);

        coffeeVendor.getCoffeeTypes();
        System.out.print("Enter the coffee name of your choice: ");
        String coffeeName = scanner.nextLine();

        System.out.print("Enter the deposit value: ");
        Integer depositValue = scanner.nextInt();

        coffeeVendor.makeCoffeeAndPayment(coffeeName, depositValue);
        coffeeVendor.checkInventory();
        coffeeVendor.getPayments();
    }
}
