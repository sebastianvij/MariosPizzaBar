import Products.Pizza;

import java.util.Scanner;

import static Menu.PizzaMenuList.pizzaList;
import static Menu.PizzaMenuList.showPizzaMenuList;

public class OrderLine {

    private Pizza pizza;
    private String size;
    private int quantity;
    private int unitPrice;

    private static final int DEFAULT_LARGE_SIZE_PRICE_INCREASE = 30;

    public OrderLine(Pizza pizza, String size, int quantity) {
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
        this.unitPrice = calculateUnitPrice(pizza, size);
    }

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

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int calculateUnitPrice(Pizza pizza, String size) {
        if (size.equals("large")) {
            return pizza.getUnitPrice() + DEFAULT_LARGE_SIZE_PRICE_INCREASE; // Default er 30
        } else {
            return pizza.getUnitPrice();
        }
    }

    public int calculateOrderLineTotalPrice(OrderLine orderLine) {
        return orderLine.getUnitPrice() * orderLine.getQuantity();
    }

    public static OrderLine createOrderLine(Scanner scanner) {
        // En OrderLine bliver skabt i 3 trin: først vælger man pizza, så størrelse og til sidst antal
        Pizza pizza;
        String size;
        int quantity;

        while (true) {
            System.out.println("Hvilken pizza kunne du tænke dig?");
            System.out.println("> Indtast pizzanummer '1 - " + pizzaList.size() + "'");
            System.out.println("> Indtast 'm' for at vise pizzamenuen");
            System.out.println("> 0. Annuller ordre");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("m")) {
                showPizzaMenuList();
                createOrderLine(scanner);
            }
            if (input.equals("0")) {
                System.out.println("Ordre annulleret");
                Main.returnerTilMainMenuPrompt(scanner);
            }
            try {
                int pizzaChoice = Integer.parseInt(input);
                if (pizzaChoice >= 1 && pizzaChoice <= pizzaList.size()) {
                    pizza = pizzaList.get(pizzaChoice - 1);
                    break;
                }
            } catch (NumberFormatException e) {

            }
            System.out.println("Ugyldigt input! Prøv igen");
        }

        while (true) {
            System.out.println("Hvilken størrelse skal din " + pizza.getName() + " pizza være?");
            System.out.println("> 1. Medium");
            System.out.println("> 2. Large");
            System.out.println("> 0. Annuller ordre");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                size = "medium";
                break;
            } else if (input.equals("2")) {
                size = "large";
                break;
            } else if (input.equals("0")) {
                System.out.println("Ordre annulleret");
                Main.returnerTilMainMenuPrompt(scanner);
            }
            System.out.println("Ugyldigt input! Prøv igen");
        }

        while (true) {
            System.out.println("Hvor mange " + size + " " + pizza.getName() + " pizza kunne du tænke dig?");
            System.out.println("> (1 - 99). Antal pizzaer");
            System.out.println("> 0. Annuller ordre");

            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("Ordre annulleret");
                Main.returnerTilMainMenuPrompt(scanner);
            } else {
                try {
                    int quantityChoice = Integer.parseInt(input);
                    if (quantityChoice >= 1 && quantityChoice <= 99) {
                        quantity = quantityChoice;
                        break;
                    }
                } catch (NumberFormatException e) {

                }
            }
            System.out.println("Ugyldigt input! Prøv igen");
        }
        if (quantity == 1) {
            System.out.println("Du har tilføjet " + quantity + " " + size + " " + pizza.getName() + " pizza til din ordre");
        } else {
            System.out.println("Du har tilføjet " + quantity + " " + size + " " + pizza.getName() + " pizzaer til din ordre");
        }
        return new OrderLine(pizza, size, quantity);
    }
}

