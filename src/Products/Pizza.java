package Products;

public class Pizza extends Product {
    private int pizzaNum;
    private String[] pizzaToppings;

    // Main Constructor
    public Pizza(String name, int unitPrice, int pizzaNum, String[] pizzaToppings) {
        super(name, unitPrice);
        this.pizzaNum = pizzaNum;
        this.pizzaToppings = pizzaToppings;
    }

    // Settere og Gettere
    public void setPizzaNum(int pizzaNum) {
        this.pizzaNum = pizzaNum;
    }

    public int getPizzaNum() {
        return pizzaNum;
    }

    public String[] getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaToppings(String[] pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }
}


