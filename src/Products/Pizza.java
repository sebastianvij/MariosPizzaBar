package Products;

public class Pizza extends Product {
    private int pizzaNum;
    private String pizzaSize;
    private String[] pizzaToppings;

    // Main Constructor
    public Pizza(String name, int price, int pizzaNum, String[] pizzaToppings) {
        super(name, price);
        this.pizzaNum = pizzaNum;
        this.pizzaToppings = pizzaToppings;
    }

    // Overloadet Constructor til hvis man vil ændre pizza størrelse
    public Pizza(String name, int price, int pizzaNum, String pizzaSize, String[] pizzaToppings) {
        super(name, price);
        this.pizzaNum = pizzaNum;
        this.pizzaSize = pizzaSize;
        this.pizzaToppings = pizzaToppings;
    }

    // Settere og Gettere
    public void setPizzaToppings(String[] pizzaToppings) {
        this.pizzaToppings = pizzaToppings;
    }

    public String[] getPizzaToppings() {
        return pizzaToppings;
    }

    public void setPizzaNum(int pizzaNum) {
        this.pizzaNum = pizzaNum;
    }

    public int getPizzaNum() {
        return pizzaNum;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }
}
