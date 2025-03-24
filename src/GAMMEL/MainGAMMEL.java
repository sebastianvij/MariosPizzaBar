package GAMMEL;

import java.util.*;

import static Menu.PizzaMenuList.ShowPizzaMenuList;

public class MainGAMMEL {
    public static List<OrderGAMMEL> orderGAMMELList = new ArrayList<>();
    public static List<OrderArchiveGAMMEL> orderArchiveGAMMELList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showMainMenu(scanner);
    }

    public static void showMainMenu(Scanner scanner) {
        while (true) {
            System.out.println("           -*-*- Marios Pizzabar -*-*-");
            System.out.println("1. Tilføj Ordre | 2. Rediger Ordre | 3. Annuller Ordre");
            System.out.println("4. Færdiggør Ordre | 5. Vis Ordreliste | 6. Vis Menu");
            System.out.println("7. Vis Ordrehistorik | 8. Vis Statistik | 9. Afslut Program");
            // Checker om brugeren indtaster et tal mellem 1 - 9 da det svarer til de 9 valgmuligheder programmet har
            String input = scanner.nextLine();
            if (!input.matches("[1-9]")) {
                System.out.println("Ukendt valg! Vælg et tal mellem 1 - 9");
            } else {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1: // Tilføj Ordre
                        break;

                    case 2: // Rediger Ordre
                        // editOrder(Scanner scanner);
                        break;

                    case 3: // Annuller Ordre
                        // cancelOrder(Scanner scanner);
                        break;

                    case 4: // Færdiggør Ordre
                        // completeOrder(Scanner scanner);

                        System.out.println("> OrdreListe");
                        for (int i = 0; i < orderGAMMELList.size(); i++) {
                            OrderGAMMEL orderGAMMELListing = orderGAMMELList.get(i);
                            System.out.println(orderGAMMELListing);
                        }

                        System.out.println("Indtast ordre nummer, på den ordre du ønsker at færdiggøre:");
                        int orderIndex = scanner.nextInt() - 1;
                        scanner.nextLine();

                        OrderGAMMEL completedOrderGAMMEL = orderGAMMELList.remove(orderIndex);
                        System.out.println("Er ordren betalt?");
                        System.out.println("Indtast '0' hvis ordren er betalt");
                        System.out.println("Indtast '1' hvis ordren ikke er betalt");
                        int paidInput = scanner.nextInt();
                        boolean isPaid = paidInput == 0;
                        OrderArchiveGAMMEL orderArchiveGAMMEL = new OrderArchiveGAMMEL(completedOrderGAMMEL, isPaid, false);
                        orderArchiveGAMMELList.add(orderArchiveGAMMEL);
                        System.out.println("Bestillingen gemt: " + completedOrderGAMMEL);
                        break;

                    case 5: // Vis Ordreliste
                        System.out.println("> OrdreListe");
                        for (OrderGAMMEL orderGAMMELListing : orderGAMMELList) {
                            System.out.println(orderGAMMELListing);
                        }
                        OrderGAMMEL.showOrderList();


                        break;
                    case 6: // Vis Menu
                        ShowPizzaMenuList();
                        break;

                    case 7: // Vis Ordrehistorik
                        // showOrderArchive();
                        break;

                    case 8: // Vis Statistik
                        // showStatistics();
                       // OrderArchive.mostPopularPizza();
                        break;

                    case 9: // Afslut Program
                        return;

                    default:
                        System.out.println("Ukendt valg, prøv venligst igen");
                        break;
                }
            }
        }
    }
}

