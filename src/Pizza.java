import java.util.ArrayList;

public class Pizza {
    private String name;
    private int price;
    private int pizzaNum;
    private String pizzaSize;
    private String[] pizzaToppings;


    // Default Constructor
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

    public void pizzaMenu() {
        ArrayList<Pizza> pizzaNames = new ArrayList<>();
        pizzaNames.add(new Pizza("Margherita", 55, 1, new String[]{"Tomatsauce", "Mozzarella", "Basilikum"}));
        pizzaNames.add(new Pizza("Vesuvio", 60, 2, new String[]{"Tomatsauce", "Mozzarella", "Skinke"}));
        pizzaNames.add(new Pizza("Hawaii", 65, 3, new String[]{"Tomatsauce", "Mozzarella", "Skinke", "Ananas"}));
        pizzaNames.add(new Pizza("Pepperoni", 62, 4, new String[]{"Tomatsauce", "Mozzarella", "Pepperoni"}));
        pizzaNames.add(new Pizza("Kebabpizza", 70, 5, new String[]{"Tomatsauce", "Mozzarella", "Kebabkød", "Løg", "Salat", "Dressing"}));
        pizzaNames.add(new Pizza("Buffalo", 66, 6, new String[]{"Tomatsauce", "Mozzarella", "Buffalo Mozzarella", "Basilikum"}));
        pizzaNames.add(new Pizza("Parma", 75, 7, new String[]{"Tomatsauce", "Mozzarella", "Parmaskinke", "Rucola", "Parmesan"}));
        pizzaNames.add(new Pizza("BBQ Kylling", 72, 8, new String[]{"BBQ-sauce", "Mozzarella", "Kylling", "Løg", "Bacon"}));
        pizzaNames.add(new Pizza("Quattro Formaggi", 78, 9, new String[]{"Tomatsauce", "Mozzarella", "Gorgonzola", "Parmesan", "Ricotta"}));
        pizzaNames.add(new Pizza("Vegetariana", 68, 10, new String[]{"Tomatsauce", "Mozzarella", "Champignon", "Løg", "Paprika", "Oliven", "Artiskok"}));
        pizzaNames.add(new Pizza("Diavola", 70, 11, new String[]{"Tomatsauce", "Mozzarella", "Pepperoni", "Chili"}));
        pizzaNames.add(new Pizza("Calzone", 74, 12, new String[]{"Tomatsauce", "Mozzarella", "Skinke", "Champignon"}));
        pizzaNames.add(new Pizza("Funghi", 60, 13, new String[]{"Tomatsauce", "Mozzarella", "Champignon"}));
        pizzaNames.add(new Pizza("Prosciutto", 73, 14, new String[]{"Tomatsauce", "Mozzarella", "Parmaskinke", "Rucola"}));
        pizzaNames.add(new Pizza("Tonno", 71, 15, new String[]{"Tomatsauce", "Mozzarella", "Tun", "Løg"}));
        pizzaNames.add(new Pizza("Salami", 69, 16, new String[]{"Tomatsauce", "Mozzarella", "Stærk Salami"}));
        pizzaNames.add(new Pizza("Bolognese", 75, 17, new String[]{"Tomatsauce", "Mozzarella", "Kødsauce", "Løg"}));
        pizzaNames.add(new Pizza("Carbonara", 76, 18, new String[]{"Tomatsauce", "Mozzarella", "Bacon", "Løg", "Æg"}));
        pizzaNames.add(new Pizza("Gorgonzola", 67, 19, new String[]{"Tomatsauce", "Mozzarella", "Gorgonzola", "Løg"}));
        pizzaNames.add(new Pizza("Æg og Bacon", 70, 20, new String[]{"Tomatsauce", "Mozzarella", "Bacon", "Æg", "Løg"}));
        pizzaNames.add(new Pizza("Fiskefilet", 80, 21, new String[]{"Tomatsauce", "Mozzarella", "Paneret Fiskefilet", "Remoulade"}));
        pizzaNames.add(new Pizza("Pommes Frites Pizza", 79, 22, new String[]{"Tomatsauce", "Mozzarella", "Pommes Frites", "Kebabkød", "Dressing"}));
        pizzaNames.add(new Pizza("Mexicana", 85, 23, new String[]{"Tomatsauce", "Mozzarella", "Nacho Chips", "Kødstrimler", "Jalapeños", "Guacamole"}));
        pizzaNames.add(new Pizza("Burger Pizza", 82, 24, new String[]{"Tomatsauce", "Mozzarella", "Hakket Oksekød", "Løg", "Pickles", "Burgerdressing"}));
        pizzaNames.add(new Pizza("Kylling i Karry", 77, 25, new String[]{"Tomatsauce", "Mozzarella", "Kylling", "Karry", "Ananas"}));
        pizzaNames.add(new Pizza("Ansjoser og Banan", 69, 26, new String[]{"Tomatsauce", "Mozzarella", "Ansjoser", "Banan", "Løg"}));
        pizzaNames.add(new Pizza("Chokolade Pizza", 65, 27, new String[]{"Nutella", "Marshmallows", "Banan", "Jordbær"}));
        pizzaNames.add(new Pizza("Rugbrøds Pizza", 58, 28, new String[]{"Rugbrødsbunde", "Remoulade", "Rødbeder", "Løg", "Spegepølse"}));
        pizzaNames.add(new Pizza("Sushi Pizza", 90, 29, new String[]{"Risbund", "Laks", "Avocado", "Agurk", "Soyasauce", "Wasabi"}));
        pizzaNames.add(new Pizza("Dessert Pizza", 72, 30, new String[]{"Vaniljesauce", "Marcipan", "Jordbær", "Hindbær", "Flormelis"}));
    }
}
