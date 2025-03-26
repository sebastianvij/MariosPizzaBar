import Menu.PizzaMenuList;
import Products.Pizza;

import java.util.Scanner;

import static Menu.PizzaMenuList.pizzaList;

public class OrderLine {

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
        return pizza.getUnitPrice() * quantity;
    }

    public static OrderLine createOrderLine(Scanner scanner) {
        PizzaMenuList.showPizzaMenuList();

        // Vælger pizza
        Pizza pizza;
        while (true) {
            System.out.println("Indtast pizzanummer '1 - " + pizzaList.size() + "' for at vælge pizza");
            System.out.println("> 0. 'Returner til menu'");

            int pizzaNumberInput = scanner.nextInt();
            scanner.nextLine();

            if (pizzaNumberInput == 0) {
                Main.showMainMenu(scanner);
            } else if (pizzaNumberInput > 0 && pizzaNumberInput < pizzaList.size() + 1) {
                pizza = pizzaList.get(pizzaNumberInput - 1);
                break;
            } else {
                System.out.println("Ugyldigt input! Prøv igen");
            }
        }

        // Vælger pizzastørrelse
        String pizzaSize;
        while (true) {
            System.out.println("Hvilken størrelse vil du gerne vælge?");
            System.out.println("> 1. 'Medium'");
            System.out.println("> 2. 'Large'");
            System.out.println("> 0. 'Returner til menu'");

            int pizzaSizeInput = scanner.nextInt();
            scanner.nextLine();

            if (pizzaSizeInput == 1) {
                pizzaSize = "m";
                break;
            } else if (pizzaSizeInput == 2) {
                pizzaSize = "l";
                break;
            } else if (pizzaSizeInput == 0) {
                Main.showMainMenu(scanner);
            } else {
                System.out.println("Ugyldigt input! Prøv igen");
            }
        }

        // Vælger antal pizza
        int quantity;
        while (true) {
            System.out.println("Indtast hvilket antal du vil have");
            System.out.println("> 0. 'Returner til menu'");

            quantity = scanner.nextInt();
            scanner.nextLine();

            if (quantity == 0) {
                Main.showMainMenu(scanner);
            } else {
                break;
            }
        }

        // Kalkuler total pris og skab pizza med førangivne værdier
        int unitPrice = pizza.getUnitPrice();
        int totalPrice = unitPrice * quantity;

        return new OrderLine(pizza, pizzaSize, quantity, totalPrice);
    }
}

