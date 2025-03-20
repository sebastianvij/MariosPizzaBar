import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//      String customerName = scanner.nextLine();
//      SimpleDateFormat Dato = new SimpleDateFormat();
//      String currentTime = Dato.format(new Date());

        // 1. Tilføj Ordre
        // 2. Rediger Ordre
        // 3. Fjern Ordre
        // 4. Færdiggør Ordre
        // 5. Se Ordreliste
        // 6. Se Menu
        // 7. Se Ordrehistorik
        // 8. Se Statistik
        // 9. Afslut Program

        System.out.println("           -*-*- Marios Pizzabar -*-*-");
        System.out.println("1. Tilføj Ordre | 2. Rediger Ordre | 3. Fjern Ordre");
        System.out.println("4. Færdiggør Ordre | 5. Vis Ordreliste | 6. Vis Menu");
        System.out.println("7. Vis Ordrehistorik | 8. Vis Statistik | 9. Afslut Program");

        while (true) {
            int input = scanner.nextInt();
            switch (input) {
                case 1: // Tilføj Ordre
                    System.out.println("Hvilken pizza vil du bestille?");
                    int pizza = scanner.nextInt();

                    System.out.println("Indtast navn på ordre");
                    String ordre = scanner.next();

                    System.out.println("Indtast telefon nummer");
                    String phoneNumber = scanner.next();

                    System.out.println("Indtast ekstra kommentarer");
                    String customerComment = scanner.next();

                    /* Når man laver vil tilføje en ordre skal man den spørge hvilke pizzaer man vil have

                    Så når man har valgt de pizzaer man vil bestille så skal man oplyse
                    navn på bestilling, optionally tlf. nr og customer comments

                    Vi laver en ArrayList, hvor der bliver spurgt hvilke
                     */
                    break;
                case 2: // Rediger Ordre

                    break;
                case 3: // Fjern Ordre
                    System.out.println("Hvilken pizza vil du fjerne fra din bestilling?");

                    break;
                case 4: // Færdiggør Ordre

                    break;
                case 5: // Vis Ordreliste

                    break;
                case 6: // Vis Menu
                    ArrayList<Pizza> pizzaList = new ArrayList<>();
                    System.out.println("---------- Menukort ----------");
                    for (Pizza p : pizzaList) {
                        System.out.println(p.getPizzaNum() + ". " + p.getName() + " - Pris: " + p.getPrice() + "\n Toppings: " + p.getPizzaToppings());
                    }
                    System.out.println("\n-------------------------");
                    break;
                case 7: // Vis Ordrehistorik

                    break;
                case 8: // Vis Statistik

                    break;
                case 9: // Afslut Program

                    break;
            }
        }
    }
}
