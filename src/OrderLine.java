public class OrderLine {
    // Det er her man er igang med at lave sin ordre. UnitPrice og quantity skal være variabler i denne klasse.

    private Pizza pizza;
    private int quantity;
    private String size;
    private double unitPrice;

    // Constructors
    public OrderLine(int quantity, double unitPrice, Pizza pizza, String size) {
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.pizza = pizza;
    }

    // Setters & Getters
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }


    // ArrayList
    // {orderlist 1, orderlist 2}
    // {3, 1, normal, 60}
    // {6, 2, normal, 58}
    //



}
