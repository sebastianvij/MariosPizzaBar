package Menu;

import Products.Pizza;

import java.util.ArrayList;
import java.util.Arrays;

public class PizzaMenuList {

    private static final int DEFAULT_LARGE_SIZE_PRICE_INCREASE = 30;

    public static final ArrayList<Pizza> pizzaList = new ArrayList<>();

    static {
        pizzaList.add(new Pizza("Margherita", 55, 1, new String[]{"Tomatsauce", "Ost", "Basilikum"}));
        pizzaList.add(new Pizza("Vesuvio", 60, 2, new String[]{"Tomatsauce", "Ost", "Skinke"}));
        pizzaList.add(new Pizza("Hawaii", 65, 3, new String[]{"Tomatsauce", "Ost", "Skinke", "Ananas"}));
        pizzaList.add(new Pizza("Pepperoni", 62, 4, new String[]{"Tomatsauce", "Ost", "Pepperoni"}));
        pizzaList.add(new Pizza("Kebabpizza", 70, 5, new String[]{"Tomatsauce", "Ost", "Kebab", "Løg", "Salat", "Dressing"}));
        pizzaList.add(new Pizza("Buffalo", 66, 6, new String[]{"Tomatsauce", "Ost", "Buffalo Mozzarella", "Basilikum"}));
        pizzaList.add(new Pizza("Thors Special", 75, 7, new String[]{"Tomatsauce", "Ost", "Tyrenosser", "Kapers", "Brocolli"}));
        pizzaList.add(new Pizza("BBQ Kylling", 72, 8, new String[]{"BBQ-sauce", "Ost", "Kylling", "Løg", "Bacon"}));
        pizzaList.add(new Pizza("Quattro Formaggi", 78, 9, new String[]{"Tomatsauce", "Ost", "Gorgonzola", "Parmesan", "Ricotta"}));
        pizzaList.add(new Pizza("Vegetariana", 68, 10, new String[]{"Tomatsauce", "Ost", "Champignon", "Løg", "Paprika", "Oliven", "Artiskok"}));
        pizzaList.add(new Pizza("Diavola", 70, 11, new String[]{"Tomatsauce", "Ost", "Pepperoni", "Chili"}));
        pizzaList.add(new Pizza("Calzone", 74, 12, new String[]{"Tomatsauce", "Ost", "Skinke", "Champignon"}));
        pizzaList.add(new Pizza("Glizzy", 60, 13, new String[]{"Tomatsauce", "Ost", "Cocktailpølser"}));
        pizzaList.add(new Pizza("Prosciutto", 73, 14, new String[]{"Tomatsauce", "Ost", "Parmaskinke", "Rucola"}));
        pizzaList.add(new Pizza("Tonno", 71, 15, new String[]{"Tomatsauce", "Ost", "Tun", "Løg"}));
        pizzaList.add(new Pizza("Salami", 69, 16, new String[]{"Tomatsauce", "Ost", "Stærk Salami"}));
        pizzaList.add(new Pizza("Bolognese", 75, 17, new String[]{"Tomatsauce", "Ost", "Kødsauce", "Løg"}));
        pizzaList.add(new Pizza("Carbonara", 76, 18, new String[]{"Tomatsauce", "Ost", "Bacon", "Løg", "Æg"}));
        pizzaList.add(new Pizza("Gorgonzola", 67, 19, new String[]{"Tomatsauce", "Ost", "Gorgonzola", "Løg"}));
        pizzaList.add(new Pizza("Æg og Bacon", 70, 20, new String[]{"Tomatsauce", "Ost", "Bacon", "Æg", "Løg"}));
        pizzaList.add(new Pizza("Fiskefilet", 80, 21, new String[]{"Tomatsauce", "Ost", "Paneret Fiskefilet", "Remoulade"}));
        pizzaList.add(new Pizza("Pommes Frites", 79, 22, new String[]{"Tomatsauce", "Ost", "Pommes Frites", "Kebabkød", "Dressing"}));
        pizzaList.add(new Pizza("Mexicana", 85, 23, new String[]{"Tomatsauce", "Ost", "Nacho Chips", "Kødstrimler", "Jalapeños", "Guacamole"}));
        pizzaList.add(new Pizza("Burger Pizza", 82, 24, new String[]{"Tomatsauce", "Ost", "Hakkebøffer", "Løg", "Pickles", "Burgerdressing"}));
        pizzaList.add(new Pizza("Kylling i Karry", 77, 25, new String[]{"Tomatsauce", "Ost", "Kylling", "Karry", "Ananas"}));
        pizzaList.add(new Pizza("Ansjoser og Banan", 69, 26, new String[]{"Tomatsauce", "Ost", "Ansjoser", "Banan", "Løg"}));
        pizzaList.add(new Pizza("Chokolade", 65, 27, new String[]{"Nutella", "Marshmallows", "Banan", "Jordbær"}));
        pizzaList.add(new Pizza("Rugbrød", 58, 28, new String[]{"Rugbrødsbunde", "Remoulade", "Rødbeder", "Løg", "Spegepølse"}));
        pizzaList.add(new Pizza("Sushi", 90, 29, new String[]{"Risbund", "Laks", "Avocado", "Agurk", "Soyasauce", "Wasabi"}));
        pizzaList.add(new Pizza("Dessert", 72, 30, new String[]{"Vaniljesauce", "Marcipan", "Jordbær", "Hindbær", "Flormelis"}));
    }

    public static void showPizzaMenuList() {
        System.out.println("-*- Menukort -*-");
        System.out.printf("%-4s %-20s %-73s %6s %5s \n", "#", "Navn", "Ingredienser", "Medium", "Stor");
        System.out.println("--------------------------------------------------------------------------------------------------");
        for (Pizza pizza : pizzaList) {
            System.out.printf("%-4d %-20s %-73s %6d,- %5d,- \n", pizza.getPizzaNum(), pizza.getName(), Arrays.toString(pizza.getPizzaToppings()), pizza.getUnitPrice(), (pizza.getUnitPrice() + DEFAULT_LARGE_SIZE_PRICE_INCREASE));
        }
        System.out.println("-*- Menukort -*-");
    }
    /*
    Formatting 101
    Printf bruges til formatting
    Komma bliver registreret som en seperator og laver automatisk + ' '
    Uden bindestreg = højrejustering
    Med bindestreg = venstrejustering
    %s bruges til strings
    %d bruges til integers
    Pizza fylder 5 tegn, %10s ville gøre at feltet er 10 tegn bredt og pizza er højrejusteret.
     */

    // Vi skal have en "Add pizza to pizza list" metode
}