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
            System.out.println("---------------------------");
        }
        Order chosenOrder;
        while (true) {
            System.out.println("Hvilken ordre vil du redigere?");
            System.out.println("> Indtast ordrenummer for at redigere ordre");
            System.out.println("> 0. Returner til hovedmenu");

            String input =  scanner.nextLine();

            if (input.equals("0")) {
                Main.showMainMenu(scanner);
            }
            try {
                int orderEditChoice = Integer.parseInt(input);
                if (orderEditChoice < 0 || orderEditChoice > activeOrders.size()) {
                    System.out.println("Ordre kan ikke findes! Prøv igen");
                } else {
                    chosenOrder = activeOrders.get(orderEditChoice - 1);
                    System.out.println("Ordre med ordrenummer: #" + chosenOrder.getOrderNumber() + " valgt");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ugyldigt input! Prøv igen");
            }
        }

        System.out.println("> 1. Redigerer ordre");
        System.out.println("> 2. Annuller ordre");
        System.out.println("> 3. Færdiggør ordre");
        System.out.println("> 0. Returner til hovedmenu");

        String input = scanner.nextLine();

        switch (input) {
            case "1": // Edit Order
                editOrder(scanner, chosenOrder);
                break;

            case "2": // Cancel Order
                chosenOrder.cancelOrder();
                System.out.println("Du har annulleret ordre #" + chosenOrder.getOrderNumber());
                break;

            case "3": // Finish Order
                chosenOrder.setComplete();
                System.out.println("Du har færdiggjort ordre #" + chosenOrder.getOrderNumber());
                break;

            case "0": // Returner til hovedmenu
                Main.showMainMenu(scanner);

            default:
                System.out.println("Ugyldigt input! Prøv igen");
        }
    }

    public static void editOrder(Scanner scanner, Order order) {
        System.out.println("Hvilken handling vil du gennemføre?");
        System.out.println("1. Tilføj pizzaer | 2. Fjern pizza | 3. Ændr pizzastørrelse");
        System.out.println("4. Tilføj kommentar | 5. Ændr afhentningstidspunkt | 0. Returner til hovedmenu");

        String input = scanner.nextLine();

        switch (input) {
            case "1": // Tilføj pizza
                order.getOrderLines().add(OrderLine.createOrderLine(scanner));
                Order.printReceipt(order);
                break;

            case "2": // Fjern pizza
                while (true) {
                    System.out.println("Hvilken pizza vil du fjerne?");
                    Order.printOrderLines(order);
                    System.out.println("> Indtast linjenummer for at fjerne pizza");
                    System.out.println("> 0. Returner til hovedmenu");

                    String input1 = scanner.nextLine();

                    if (input1.equals("0")) {
                        Main.showMainMenu(scanner);
                    }
                    try {
                        int removePizzaChoice = Integer.parseInt(input1);
                        if (removePizzaChoice > 0 && removePizzaChoice <= order.getOrderLines().size()) {
                            System.out.println("Du har fjernet linjenummer " + input1 + " fra ordren");
                            order.getOrderLines().remove(removePizzaChoice - 1);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldigt input! Prøv igen.");
                    }
                }
                break;

            case "3": // Ændre pizzastørrelse
                while (true) {
                    System.out.println("Hvilken pizza vil du ændre størrelse på?");
                    Order.printOrderLines(order);
                    System.out.println("> Indtast linjenummer for at ændre pizzastørrelse");
                    System.out.println("> 0. Returner til hovedmenu");

                    String input1 = scanner.nextLine();
                    int editPizzaSizeChoice = 0;

                    if (input1.equals("0")) {
                        Main.showMainMenu(scanner);
                        return;
                    }

                    try {
                        editPizzaSizeChoice = Integer.parseInt(input1);
                        if (editPizzaSizeChoice > 0 && editPizzaSizeChoice <= order.getOrderLines().size()) {
                            System.out.println("Du har valgt at ændre linjenummer " + input1 + "'s pizzastørrelse");
                            OrderLine pizza = order.getOrderLines().get(editPizzaSizeChoice - 1);
                            String pizzaSize = pizza.getSize();

                            if (pizzaSize.equals("medium")) {
                                while (true) {
                                    System.out.println("Den nuværende pizza er medium størrelse. Vil du gerne ændre til large?");
                                    System.out.println("> 1. Ændr til large");
                                    System.out.println("> 0. Forbliv medium");

                                    String sizeChoice = scanner.nextLine();
                                    if (sizeChoice.equals("1")) {
                                        pizzaSize = "large";
                                        break;
                                    } else if (sizeChoice.equals("0")) {
                                        break;
                                    } else {
                                        System.out.println("Ugyldigt input! Prøv igen.");
                                    }
                                }
                            } else {
                                while (true) {
                                    System.out.println("Den nuværende pizza er large størrelse. Vil du gerne ændre til medium?");
                                    System.out.println("> 1. Ændr til medium");
                                    System.out.println("> 0. Forbliv large");

                                    String sizeChoice = scanner.nextLine();
                                    if (sizeChoice.equals("1")) {
                                        pizzaSize = "medium";
                                        break;
                                    } else if (sizeChoice.equals("0")) {
                                        break;
                                    } else {
                                        System.out.println("Ugyldigt input! Prøv igen.");
                                    }
                                }
                            }
                            pizza.setSize(pizzaSize);
                            System.out.println("Størrelsen er ændret til: " + pizzaSize);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldigt input! Prøv igen.");
                    }
                }
                break;

            case "4": // Tilføj kommentar
                System.out.println("Tilføj kommentar:");
                String newCustommerComment = scanner.nextLine();
                order.setCustomerComment(newCustommerComment);
                break;

            case "5": // Ændr afhentningstidspunkt
                order.setPickupTime(Order.setPickUpTime(scanner));
                break;

            case "6": // Returner til hovedmenu
                Main.showMainMenu(scanner);
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

    public static void showStatisticsMenu(Scanner scanner) {
        while (true) {
            System.out.println("Hvilken statistik vil du se?");
            System.out.println("> 1. Vis den totale omsætning");
            System.out.println("> 2. Vis den mest populære pizza");
            System.out.println("> 0. Returner til hovedmenu");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                showRevenue(scanner);
                break;
            } else if (input.equals("2")) {
                showMostPopularPizza(scanner);
                break;
            } else if (input.equals("0")) {
                break;
            } else {
                System.out.println("Ugyldigt input! Prøv igen.");
            }
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
        Main.returnerTilMainMenuPrompt(scanner);
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
        } else {
            System.out.println("Den most populære pizza er: " + mostPopularPizza.getName() + "pizza. Den er købt: " + maxCount + " gange");
        }
        Main.returnerTilMainMenuPrompt(scanner);
    }
}
