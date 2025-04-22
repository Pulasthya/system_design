import java.util.HashMap;

public class Coffee {
    private String name;
    private HashMap<String, Integer> ingredients = new HashMap<>();
    private Integer price;

    public Coffee(String name, HashMap<String, Integer> ingredients, Integer price) {
        this.name = name;
        this.ingredients = ingredients;
        this.price = price;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized HashMap<String, Integer> getIngredients() {
        return ingredients;
    }

    public synchronized Integer getPrice() {
        return price;
    }
}
