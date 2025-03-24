package GAMMEL;

import Products.Pizza;

import java.util.ArrayList;
import java.util.Scanner;

import static Menu.PizzaMenuList.ShowPizzaMenuList;
import static Menu.PizzaMenuList.pizzaList;

public class OrderLineGAMMEL {
    // Det er her man er igang med at lave sin ordre. UnitPrice og quantity skal være variabler i denne klasse.

    private Pizza pizza;
    private String size;
    private int quantity;
    private int unitPrice;

    // Constructors
    public OrderLineGAMMEL(Pizza pizza, String size, int quantity, int unitPrice) {
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

    public static void choosePizzas(Scanner scanner) {
        System.out.println("-*- 1. Tilføj Ordre -*-");
        ArrayList<OrderLineGAMMEL> orderLineGAMMELS = new ArrayList<>();

        // Brugeren vælger pizza
        int pizzaNumber = 0;
        while (true) {
            System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
            System.out.println("> Indtast 'menu' for at vise menuen");
            System.out.println("> Indtast '0' for at annullere ordre");
            String pizzaChoice = scanner.nextLine();
            if (pizzaChoice.equalsIgnoreCase("0")) {
                MainGAMMEL.showMainMenu(scanner);
                break;
            } else if (pizzaChoice.equals("menu")) {
                ShowPizzaMenuList();
                break;
            }
            try {
                pizzaNumber = Integer.parseInt(pizzaChoice);
                if (pizzaNumber < 1 || pizzaNumber > pizzaList.size()) {
                    System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
            }
        }
        String pizzaName = pizzaList.get(pizzaNumber - 1).getName();
        System.out.println("> '" + pizzaName + "' valgt. Hvilken størrelse skal det være?");

        // Brugeren vælger størrelse
        String pizzaSize = null;
        while (true) {
            System.out.println("> Indtast 'M' for at vælge en mellem pizza");
            System.out.println("> Indtast 'L' for at vælge en stor pizza");
            System.out.println("> Indtast '0' for at annullere pizzavalg");
            String sizeChoice = scanner.nextLine();
            if (sizeChoice.equals("0")) {
                // VÆLG NY PIZZA
                break;
            }
            pizzaSize = (sizeChoice.equalsIgnoreCase("L")) ? "large" : (sizeChoice.equalsIgnoreCase("M")) ? "medium" : null;

            if (pizzaSize != null) {
                break;
            }
        }
        System.out.println("> " + (pizzaSize.equals("large") ? "Stor" : "Medium") + " '" + pizzaName + "' valgt. Hvor mange skal det være?");

        // Brugeren vælger antal
        int quantity = 0;
        while (true) {
            System.out.println("> Indtast '1 - 99' for at vælge antal " + (pizzaSize.equals("large") ? "store" : "medium") + " " + pizzaName);
            System.out.println("> Indtast '0' for at annullere pizzavalg");
            String quantityChoice = scanner.nextLine();
            try {
                quantity = Integer.parseInt(quantityChoice);
                if (quantity == 0) {
                    // VÆLG NY PIZZA
                    break;
                } else if (quantity > 0 && quantity < 100) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("> Prøv igen");
            }
        }
        System.out.println("> " + quantity + " " + (pizzaSize.equals("large") ? "store" : "medium") + " '" + pizzaName + "' valgt. Vil du tilføje flere pizzaer?");

        // Brugeren kan vælge at tilføje flere pizzaer, ellers er ordren færdiggjort
        System.out.println("> Indtast '1' for at tilføje en ny pizza");
        System.out.println("> Indtast '0' for at færdiggøre ordre");
        String addOrFinishOrderChoice = scanner.nextLine();

        if (addOrFinishOrderChoice.equals("1")) {
            orderLineGAMMELS.add(new OrderLineGAMMEL(pizzaList.get(pizzaNumber - 1), pizzaSize, quantity, pizzaList.get(pizzaNumber - 1).getPrice()));
            choosePizzas(scanner);
        } else if (addOrFinishOrderChoice.equals("0")) {
            OrderGAMMEL.custommerInformation(scanner, orderLineGAMMELS);
        }
    }
}
