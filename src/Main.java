import Menu.PizzaMenuList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showMainMenu(scanner);
    }

    public static void showMainMenu(Scanner scanner) {
        System.out.println("           -*-*- Marios Pizzabar -*-*-");
        System.out.println("1. Tilføj Ordre | 2. Vis Aktive Ordrer | 3. Vis Pizzamenu");
        System.out.println("4. Vis Ordrehistorik | 5. Vis Statistik | 0. Afslut Program");

        String input = scanner.nextLine();
        switch (input) {
            case "1": // Tilføj Ordre
                ArrayList<OrderLine> orderLineArrayList = new ArrayList<>();
                orderLineArrayList.add(OrderLine.createOrderLine(scanner));

                while (true) {
                    System.out.println("Vil du tilføje flere pizzaer? ");
                    System.out.println("> 1.  ");
                    System.out.println("> Tast '0' ");
                    String addPizzaInput = scanner.nextLine();

                    if (addPizzaInput.equalsIgnoreCase("Ja")) {
                        orderLineArrayList.add(OrderLine.createOrderLine(scanner));
                    } else if (addPizzaInput.equalsIgnoreCase("Nej")) {
                        break;
                    } else {
                        System.out.println("Prøv igen");
                    }
                }

                Order.createOrder(scanner, orderLineArrayList);

                showMainMenu(scanner);
                break;

            case "2": // Vis Odreliste: Rediger/Slet/Afslut
                OrderArchive.showActiveOrders(scanner);
                showMainMenu(scanner);
                break;

            case "3": //Vis menu
                PizzaMenuList.showPizzaMenuList();
                showMainMenu(scanner);
                break;

            case "5": // Vis totale omsætning
                OrderArchive.showRevenue(scanner);
                showMainMenu(scanner);

        }
    }
}