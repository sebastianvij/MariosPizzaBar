package Products;

public class Product {
    private String name;
    private int price;

    // Constructor
    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    // Settere og Gettere
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}

