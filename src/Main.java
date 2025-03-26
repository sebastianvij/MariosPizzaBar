import Menu.PizzaMenuList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showMainMenu(scanner);
    }

    // Kører i ring for evigt. Stoppes først når man afslutter programmet '0'
    public static void showMainMenu(Scanner scanner) {
        System.out.println("           -*-*- Marios Pizzabar -*-*-");
        System.out.println("1. Tilføj Ordre | 2. Vis Ordreliste | 3. Vis Pizzamenu");
        System.out.println("4. Vis Ordrehistorik | 5. Vis Statistik | 0. Afslut Program");

        String input = scanner.nextLine();
        switch (input) {
            case "0": // Afslut Program
                System.out.println("Afslutter program...");
                return;

            case "1": // Tilføj Ordre
                ArrayList<OrderLine> orderLineArrayList = new ArrayList<>();
                orderLineArrayList.add(OrderLine.createOrderLine(scanner));

                while (true) {
                    System.out.println("Vil du tilføje flere pizzaer?");
                    System.out.println("> 1. Tilføj flere pizzaer");
                    System.out.println("> 2. Færdiggør bestilling");
                    System.out.println("> 0. Annuller ordre");

                    String addPizzaInput = scanner.nextLine();

                    if (addPizzaInput.equals("1")) {
                        orderLineArrayList.add(OrderLine.createOrderLine(scanner));
                    } else if (addPizzaInput.equals("2")) {
                        Order.createOrder(scanner, orderLineArrayList);
                        break;
                    } else if (addPizzaInput.equals("0")) {
                        System.out.println("Ordre annulleret");
                        showMainMenu(scanner);
                    } else {
                        System.out.println("Ugyldigt input! Prøv igen");
                    }
                }
                break;

            case "2": // Vis Ordreliste (Rediger/Annuller/Færdiggør)
                OrderArchive.showActiveOrders(scanner);
                break;

            case "3": // Vis Pizzamenu
                PizzaMenuList.showPizzaMenuList();
                break;

            case "4": // Ordrehistorik
                OrderArchive.showFinishedOrders();
                break;

            case "5": // Vis Statistik (Omsætning/Mest Populære Pizza)
                OrderArchive.showStatisticsMenu(scanner);
                break;

            default:
                System.out.println("Ugyldigt input! Prøv igen");
        }
        showMainMenu(scanner);
    }
}