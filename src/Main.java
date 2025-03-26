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
                    System.out.println("Vil du tilføje flere pizzaer?");
                    System.out.println("> 1. 'Tilføj flere");
                    System.out.println("> 0. 'Færdiggør bestilling'");
                    int addPizzaInput = scanner.nextInt();
                    scanner.nextLine();

                    if (addPizzaInput == 1) {
                        orderLineArrayList.add(OrderLine.createOrderLine(scanner));
                    } else if (addPizzaInput == 0) {
                        break;
                    } else {
                        System.out.println("Ugyldigt input! Prøv igen");
                    }
                }
                Order.createOrder(scanner, orderLineArrayList);

                showMainMenu(scanner);
                break;

            case "2": // Vis Odreliste (Rediger/Slet/Afslut)
                OrderArchive.showActiveOrders(scanner);
                showMainMenu(scanner);
                break;

            case "3": //Vis menu
                PizzaMenuList.showPizzaMenuList();
                showMainMenu(scanner);
                break;

            case "4": // Ordrehistorik
                OrderArchive.showFinishedOrders();
                break;

            case "5": // Vis totale omsætning og stats
                OrderArchive.statisticsMenu(scanner);
                showMainMenu(scanner);
                break;

            default:
                System.out.println("Ugyldigt input! Prøv igen");
                showMainMenu(scanner);
        }
    }
}