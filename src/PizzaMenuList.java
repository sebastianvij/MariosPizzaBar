import java.util.ArrayList;

public class PizzaMenuList {
    private String name;
    private int price;
    private int pNum;
    private String pSize;
    private String pCondiments;

    //Constructor
    public PizzaMenuList(String name, int price, int pNum, String pSize, String pCondiments) {
        this.name=name;
        this.price=price;
        this.pNum=pNum;
        this.pSize=pSize;
        this.pCondiments=pCondiments;
    }
    //Settere og gettere
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

    public void setpCondiments(String pCondiments) {
        this.pCondiments = pCondiments;
    }

    public String getpCondiments() {
        return pCondiments;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public String getpSize() {
        return pSize;
    }

    public void pizzaList() {
        ArrayList<String> pizzaNames = new ArrayList<>();
        pizzaNames.add("Margherita");
        pizzaNames.add("Vesuvio");
        pizzaNames.add("Hawaii");
        pizzaNames.add("Pepperoni");
        pizzaNames.add("Kebabpizza");
        pizzaNames.add("Buffalo");
        pizzaNames.add("Parma");
        pizzaNames.add("BBQ Kylling");
        pizzaNames.add("Quattro Formaggi");
        pizzaNames.add("Vegetariana");
        pizzaNames.add("Diavola");
        pizzaNames.add("Calzone");
        pizzaNames.add("Funghi");
        pizzaNames.add("Proscuitto");
        pizzaNames.add("Tonno");
        pizzaNames.add("Salami");
        pizzaNames.add("Bolognese");
        pizzaNames.add("Carbonara");
        pizzaNames.add("Gorgonzola");
        pizzaNames.add("Æg og Bacon");
        pizzaNames.add("Fiskefilet");
        pizzaNames.add("Pommes Frites Pizza");
        pizzaNames.add("Mexicana");
        pizzaNames.add("Burger Pizza");
        pizzaNames.add("Kylling i karry");
        pizzaNames.add("Ansjoser og banan");
        pizzaNames.add("Chokolade Pizza");
        pizzaNames.add("Rugbrøds Pizza");
        pizzaNames.add("Sushi Pizza");
        pizzaNames.add("Dessert Pizza");
    }
}
