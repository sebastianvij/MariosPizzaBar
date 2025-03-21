import Products.Pizza;

public class OrderLine {
    // Det er her man er igang med at lave sin ordre. UnitPrice og quantity skal være variabler i denne klasse.

    private Pizza pizza;
    private String size;
    private int quantity;
    private int unitPrice;

    // Constructors
    public OrderLine(Pizza pizza, String size, int quantity, int unitPrice) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    // Setters & Getters
    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getOrderLineTotalPrice() {
        return pizza.getPrice() * quantity;
    }

    // ArrayList
    // {orderlist 1, orderlist 2}
    // {3, 1, normal, 60}
    // {6, 2, normal, 58}
    //



}
