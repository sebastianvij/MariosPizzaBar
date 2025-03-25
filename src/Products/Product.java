package Products;

public class Product {
    private String name;
    private int unitPrice;

    // Constructor
    public Product(String name, int unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Settere og Gettere
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getUnitPrice() {
        return unitPrice;
    }
}

