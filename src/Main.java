import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        showMainMenu(scanner);
    }

    public static void showMainMenu(Scanner scanner) {

        // -*-*- Marios Pizzabar -*-*-");
        // 1. Tilføj Ordre
        // 2. Vis Ordreliste - Rediger, Slet, Færdiggør"
        // 3. Vis Menu
        // 4. Vis Ordrehistorik" +
        // 5. Vis Statistik " +
        // 0. Afslut Program");

        String input = scanner.nextLine();

        switch (input) {
            case "1": // Tilføj Ordre

                ArrayList<OrderLine> orderLines = new ArrayList<>();


                // Opretter ordreline:
                // 1. Vælg pizza type

                // 2. Vælg størrelse

                // 3. Vælg antal

                orderLines.add(OrderLine.createOrderLine(scanner));

                // Spørg om man vil tilføje flere pizzaer
                while (true) {
                    System.out.println("Tilføj pizzaer tast Ja");
                    String addPizzaInput = scanner.nextLine();

                    if (addPizzaInput.equalsIgnoreCase("Ja")) {
                        orderLines.add(OrderLine.createOrderLine(scanner));
                    } else if (addPizzaInput.equalsIgnoreCase("Nej")) {
                        break;
                    } else {
                        System.out.println("Prøv igen");
                    }
                }

                System.out.println(orderLines);

                // Når man er færdig med at bestille pizzaer oprettes orden
                // 1. Indtast navn
                // 2. Indtast afhentningstidspunkt
                // 3. Indtast yderlige kommentarer

                // Så printer den den fulde ordre med alle oplysninger
                // Så gemmes ordren i ordre arkiv

        }
    }
}