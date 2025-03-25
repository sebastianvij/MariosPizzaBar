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

            System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");

            int pizzaNumber = scanner.nextInt();
            scanner.nextLine();

            Pizza pizza = pizzaList.get(pizzaNumber - 1);

            System.out.println("Størrelse");

            String pizzaSize = scanner.nextLine();

            System.out.println("Antal");

            int quantity = scanner.nextInt();
            scanner.nextLine();

            int unitPrice = pizza.getUnitPrice();

            if (pizzaSize.equalsIgnoreCase("l")) {
                unitPrice += 30;
            }

            int totalPrice = unitPrice * quantity;

            OrderLine orderLine = new OrderLine(pizza, pizzaSize, quantity, totalPrice);

            return orderLine;
    }
}
