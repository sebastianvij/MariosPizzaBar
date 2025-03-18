import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String customerName = scanner.nextLine();
//        SimpleDateFormat Dato = new SimpleDateFormat();
//        String currentTime = Dato.format(new Date());

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

                    break;
                case 2: // Rediger Ordre
                case 3: // Fjern Ordre
                case 4: // Færdiggør Ordre
                case 5: // Vis Ordreliste
                case 6: // Vis Menu
                    System.out.println();
                    break;
                case 7: // Vis Ordrehistorik
                case 8: // Vis Statistik
                case 9: // Afslut Program

            }

        }

    }
}
