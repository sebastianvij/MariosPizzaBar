import Menu.PizzaMenuList;
import Products.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderArchive {

    private static List<Order> orderArchive = new ArrayList<>();

    public static void addOrderToArchive(Order order) {
        orderArchive.add(order);
    }

    public static void showActiveOrders(Scanner scanner) {
        if (orderArchive.isEmpty()) {
            System.out.println("Der er ingen aktive ordre");
            return;
        }
        System.out.println("Aktive ordrer: ");
        for (Order order : orderArchive) {
            if (order.isActive())  {
                System.out.println(order);
            }
        }
        System.out.println("Hvilken ordre vil du redigere?");

        int orderNumber = scanner.nextInt() - 1;
        Order chosenOrder = orderArchive.get(orderNumber);
        scanner.nextLine();

        System.out.println("Tast 1 for at redigere ordren");
        System.out.println("Tast 2 for at annullere ordren");
        System.out.println("Tast 3 for at færdiggøre ordren");
        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1: // Edit Order
                editOrder(scanner, chosenOrder);
                break;

            case 2: // Cancel Order
                chosenOrder.cancelOrder();
                break;

            case 3: // Finish Order
                chosenOrder.setComplete();
                break;
        }
    }

    public static void editOrder(Scanner scanner, Order order) {

        System.out.println("Hvilken handling vil du gennemføre?");
        System.out.println("1. Tilføj pizzaer | 2. Fjern pizza | 3. Ændre pizzastørrelse");
        System.out.println("4. Tilføj kommentar | 5. Ændre afhentningstidspunkt");

        int input = scanner.nextInt();
        scanner.nextLine();

        switch (input) {
            case 1: // Tilføj pizza
                order.getOrderLines().add(OrderLine.createOrderLine(scanner));
                Order.printReceipt(order);
                break;

            case 2: // Fjern pizza
                System.out.println("> Hvilken pizza vil du fjerne?");
                Order.printOrderLines(order);
                int removePizzaChoice = scanner.nextInt();
                scanner.nextLine();

                order.getOrderLines().remove(removePizzaChoice - 1);

                System.out.println("> Du har fjernet en pizza fra ordren"); // Skal den kunne finde den specifikke pizza?
                break;

            case 3: // Ændre pizzastørrelse
                System.out.println("> Hvilken pizza vil du ændre størrelse på?");
                Order.printOrderLines(order);

                int editPizzaSizeChoice = scanner.nextInt();
                scanner.nextLine();

                OrderLine pizza = order.getOrderLines().get(editPizzaSizeChoice - 1);
                String pizzaSize = pizza.getSize();


                if (pizzaSize.equalsIgnoreCase("M")) {
                    System.out.println("Den nuværende pizza er medium størrelse. Vil du gerne ændre til Large?");
                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sizeChoice == 1) {
                        pizza.setSize("l");
                    } else if (sizeChoice == 0) {
                        break;
                    }
                } else {
                    System.out.println("Den nuværende pizza er large størrelse. Vil du gerne ændre til Medium?");
                    int sizeChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sizeChoice == 1) {
                        pizza.setSize("m");
                    } else if (sizeChoice == 0) {
                        break;
                    }
                }
                System.out.println("Størrelsen er ændret til: " + order.getOrderLines().get(editPizzaSizeChoice).getSize());
                break;

            case 4:
                showFinishedOrders();
                break;
            case 5:
                statisticsMenu(scanner);
                break;
            case 6: //
        }
    }

    public static void showFinishedOrders() {
        System.out.println("> Afsluttede ordrer: ");
        for (Order order : orderArchive) {
            if (!order.isActive() && order.isPaid()) {
                System.out.println(order);
            }
        }
    }

    public static void statisticsMenu(Scanner scanner) {
        System.out.println("Tast 1 for at se den totale omsætning");
        System.out.println("Tast 2 for at se den mest populære pizza");
        int input = scanner.nextInt();
        if (input == 1) {
            showRevenue(scanner);
        } else if (input == 2) {
            showMostPopularPizza();
        } else {
            System.out.println("Prøv igen");
        }
    }

    public static void showRevenue(Scanner scanner) {
        int revenue = 0;
        for (Order order : orderArchive) {
            if (order.isPaid() && !order.isActive()) {
                revenue += order.getOrderTotalPrice();
            }
        }
        System.out.println("Den totale omsætning er: " + revenue);
        System.out.println("Tryk '0' for at gå tilbage til menuen");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input == 0) {
        Main.showMainMenu(scanner);
        } else {
            System.out.println("Prøv igen");
        }

    }
    public static Order showMostPopularPizza() {

        Order mostPopularPizza = null;
        int maxCount = 0;

        for (int i = 0; i < orderArchive.size(); i++) {
            Order pizza = orderArchive.get(i);
            int count = 0;

        for (int j = 0; j < orderArchive.size(); j++) {
            if (orderArchive.get(j) == pizza) {
                count++;
            }
        }
            // Hvis pizzaen er mere populær end den nuværende, opdater
            if (count > maxCount) {
                maxCount = count;
                mostPopularPizza = pizza;
            }
        }
        return mostPopularPizza;
    }



}
