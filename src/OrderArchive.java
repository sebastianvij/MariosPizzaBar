import Products.Pizza;

import java.util.*;

public class OrderArchive {

    private static List<Order> orderArchive = new ArrayList<>();
    private static List<Order> activeOrders = new ArrayList<>();

    public static void addOrderToArchive(Order order) {
        orderArchive.add(order);
    }

    public static void removeOrderFromActiveOrder(Order order) {
        activeOrders.remove(order);
    }

    public static void showActiveOrders(Scanner scanner) {

        if (orderArchive.isEmpty()) {
            System.out.println("Der er ingen aktive ordre");
            return;
        }
        activeOrders.clear();

        System.out.println("Aktive ordrer: ");
        for (Order order : orderArchive) {
            if (order.isActive()) {
                activeOrders.add(order);
            }
        }
        if (activeOrders.isEmpty()) {
            System.out.println("Der er ingen aktive ordre");
            return;
        }

        Collections.sort(activeOrders, Comparator.comparing(Order::getPickupTime));

        for (Order order : activeOrders) {
            Order.printReceipt(order);
        }

        Order chosenOrder;
        while (true) {
            System.out.println("Hvilken ordre vil du redigere?");
            System.out.println("> 0. 'Returner til menu'");

            int orderEditChoice = scanner.nextInt() - 1;
            scanner.nextLine();

            if (orderEditChoice == 0 ) {
                Main.showMainMenu(scanner);
            }

            if (orderEditChoice < 0 || orderEditChoice >= orderArchive.size() || !orderArchive.get(orderEditChoice).isActive()) {
                System.out.println("Ordre kan ikke findes, prøv igen.");
            } else {
                chosenOrder = orderArchive.get(orderEditChoice);
                break;
            }
        }
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
                System.out.println("Du har annulleret ordren");
                break;

            case 3: // Finish Order
                chosenOrder.setComplete();
                System.out.println("Du har færdiggjort ordren");
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
                Order.printReceipt(order);
            }
        }
    }

    public static void statisticsMenu(Scanner scanner) {
        System.out.println("Tast 1 for at se den totale omsætning");
        System.out.println("Tast 2 for at se den mest populære pizza");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input == 1) {
            showRevenue(scanner);
        } else if (input == 2) {
            showMostPopularPizza(scanner);
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

    public static void showMostPopularPizza(Scanner scanner) {

        Pizza mostPopularPizza = null;
        int maxCount = 0;

        for (int i = 0; i < orderArchive.size(); i++) {
            Pizza pizza = orderArchive.get(i).getOrderLines().get(i).getPizza();
            int count = 0;

            for (int j = 0; j < orderArchive.size(); j++) {
                if (orderArchive.get(j).getOrderLines().get(j).getPizza() == pizza) {
                count += (orderArchive.get(j).getOrderLines().get(j).getQuantity());
            }
        }

            // Hvis pizzaen er mere populær end den nuværende, opdater
            if (count > maxCount) {
                maxCount = count;
                mostPopularPizza = pizza;
            }
        }
        if (mostPopularPizza == null) {
            System.out.println("Ingen bestillinger er blevet oprettet endnu");
            return;
        }
        System.out.println("Den most populære pizza er: " + mostPopularPizza.getName() + " Antal gange købt: " + maxCount);
        System.out.println("Tryk '0' for at gå tilbage til menuen");
        int input = scanner.nextInt();
        scanner.nextLine();

        if (input == 0) {
            Main.showMainMenu(scanner);
        } else {
            System.out.println("Prøv igen");
        }
    }
}
