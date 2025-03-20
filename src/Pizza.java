import java.util.ArrayList;

public class Pizza extends Product {
    private String name;
    private int price;
    private int pizzaNum;
    private String pizzaSize;
    private String[] pizzaToppings;
    private static ArrayList<Pizza> pizzaMenuList;

    // Main Constructor
    public Pizza(String name, int price, int pizzaNum, String[] pizzaToppings) {
        this.name = name;
        this.price = price;
        this.pizzaNum = pizzaNum;
        this.pizzaToppings = pizzaToppings;
    }

    // Overloadet Constructor til hvis man vil ændre pizza størrelse
    public Pizza(String name, int price, int pizzaNum, String pizzaSize, String[] pizzaToppings) {
        this.name = name;
        this.price = price;
        this.pizzaNum = pizzaNum;
        this.pizzaSize = pizzaSize;
        this.pizzaToppings = pizzaToppings;
    }

    // Settere og Getters
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

    public static void pizzaMenu() {
        pizzaMenuList = new ArrayList<>();
        pizzaMenuList.add(new Pizza("Margherita", 55, 1, new String[]{"Tomatsauce", "Mozzarella", "Basilikum"}));
        pizzaMenuList.add(new Pizza("Vesuvio", 60, 2, new String[]{"Tomatsauce", "Mozzarella", "Skinke"}));
        pizzaMenuList.add(new Pizza("Hawaii", 65, 3, new String[]{"Tomatsauce", "Mozzarella", "Skinke", "Ananas"}));
        pizzaMenuList.add(new Pizza("Pepperoni", 62, 4, new String[]{"Tomatsauce", "Mozzarella", "Pepperoni"}));
        pizzaMenuList.add(new Pizza("Kebabpizza", 70, 5, new String[]{"Tomatsauce", "Mozzarella", "Kebabkød", "Løg", "Salat", "Dressing"}));
        pizzaMenuList.add(new Pizza("Buffalo", 66, 6, new String[]{"Tomatsauce", "Mozzarella", "Buffalo Mozzarella", "Basilikum"}));
        pizzaMenuList.add(new Pizza("Parma", 75, 7, new String[]{"Tomatsauce", "Mozzarella", "Parmaskinke", "Rucola", "Parmesan"}));
        pizzaMenuList.add(new Pizza("BBQ Kylling", 72, 8, new String[]{"BBQ-sauce", "Mozzarella", "Kylling", "Løg", "Bacon"}));
        pizzaMenuList.add(new Pizza("Quattro Formaggi", 78, 9, new String[]{"Tomatsauce", "Mozzarella", "Gorgonzola", "Parmesan", "Ricotta"}));
        pizzaMenuList.add(new Pizza("Vegetariana", 68, 10, new String[]{"Tomatsauce", "Mozzarella", "Champignon", "Løg", "Paprika", "Oliven", "Artiskok"}));
        pizzaMenuList.add(new Pizza("Diavola", 70, 11, new String[]{"Tomatsauce", "Mozzarella", "Pepperoni", "Chili"}));
        pizzaMenuList.add(new Pizza("Calzone", 74, 12, new String[]{"Tomatsauce", "Mozzarella", "Skinke", "Champignon"}));
        pizzaMenuList.add(new Pizza("Funghi", 60, 13, new String[]{"Tomatsauce", "Mozzarella", "Champignon"}));
        pizzaMenuList.add(new Pizza("Prosciutto", 73, 14, new String[]{"Tomatsauce", "Mozzarella", "Parmaskinke", "Rucola"}));
        pizzaMenuList.add(new Pizza("Tonno", 71, 15, new String[]{"Tomatsauce", "Mozzarella", "Tun", "Løg"}));
        pizzaMenuList.add(new Pizza("Salami", 69, 16, new String[]{"Tomatsauce", "Mozzarella", "Stærk Salami"}));
        pizzaMenuList.add(new Pizza("Bolognese", 75, 17, new String[]{"Tomatsauce", "Mozzarella", "Kødsauce", "Løg"}));
        pizzaMenuList.add(new Pizza("Carbonara", 76, 18, new String[]{"Tomatsauce", "Mozzarella", "Bacon", "Løg", "Æg"}));
        pizzaMenuList.add(new Pizza("Gorgonzola", 67, 19, new String[]{"Tomatsauce", "Mozzarella", "Gorgonzola", "Løg"}));
        pizzaMenuList.add(new Pizza("Æg og Bacon", 70, 20, new String[]{"Tomatsauce", "Mozzarella", "Bacon", "Æg", "Løg"}));
        pizzaMenuList.add(new Pizza("Fiskefilet", 80, 21, new String[]{"Tomatsauce", "Mozzarella", "Paneret Fiskefilet", "Remoulade"}));
        pizzaMenuList.add(new Pizza("Pommes Frites Pizza", 79, 22, new String[]{"Tomatsauce", "Mozzarella", "Pommes Frites", "Kebabkød", "Dressing"}));
        pizzaMenuList.add(new Pizza("Mexicana", 85, 23, new String[]{"Tomatsauce", "Mozzarella", "Nacho Chips", "Kødstrimler", "Jalapeños", "Guacamole"}));
        pizzaMenuList.add(new Pizza("Burger Pizza", 82, 24, new String[]{"Tomatsauce", "Mozzarella", "Hakket Oksekød", "Løg", "Pickles", "Burgerdressing"}));
        pizzaMenuList.add(new Pizza("Kylling i Karry", 77, 25, new String[]{"Tomatsauce", "Mozzarella", "Kylling", "Karry", "Ananas"}));
        pizzaMenuList.add(new Pizza("Ansjoser og Banan", 69, 26, new String[]{"Tomatsauce", "Mozzarella", "Ansjoser", "Banan", "Løg"}));
        pizzaMenuList.add(new Pizza("Chokolade Pizza", 65, 27, new String[]{"Nutella", "Marshmallows", "Banan", "Jordbær"}));
        pizzaMenuList.add(new Pizza("Rugbrøds Pizza", 58, 28, new String[]{"Rugbrødsbunde", "Remoulade", "Rødbeder", "Løg", "Spegepølse"}));
        pizzaMenuList.add(new Pizza("Sushi Pizza", 90, 29, new String[]{"Risbund", "Laks", "Avocado", "Agurk", "Soyasauce", "Wasabi"}));
        pizzaMenuList.add(new Pizza("Dessert Pizza", 72, 30, new String[]{"Vaniljesauce", "Marcipan", "Jordbær", "Hindbær", "Flormelis"}));
    }

    // Get PizzaMenuList
    public ArrayList<Pizza> getPizzaMenuList() {
        return pizzaMenuList;
    }
}
