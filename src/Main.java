import Menu.PizzaMenuList;
import Products.Pizza;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

import static Menu.PizzaMenuList.pizzaList;

public class Main {
    public static List<Order> orderList = new ArrayList<>();
    private static final int DEFAULT_ORDER_DELAY_IN_MINUTES = 15;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 1. Tilføj Ordre
        // 2. Rediger Ordre
        // 3. Fjern Ordre
        // 4. Færdiggør Ordre
        // 5. Se Ordreliste
        // 6. Se Menu
        // 7. Se Ordrehistorik
        // 8. Se Statistik
        // 9. Afslut Program



        while (true) {
            System.out.println("           -*-*- Marios Pizzabar -*-*-");
            System.out.println("1. Tilføj Ordre | 2. Rediger Ordre | 3. Annuller Ordre");
            System.out.println("4. Færdiggør Ordre | 5. Vis Ordreliste | 6. Vis Menu");
            System.out.println("7. Vis Ordrehistorik | 8. Vis Statistik | 9. Afslut Program");
            // Checker om brugeren indtaster et tal mellem 1 - 9 da det svarer til de 9 valgmuligheder programmet har
            int input;
            try {
                input = scanner.nextInt();

                if (input < 1 || input > 9) {
                    System.out.println("Ukendt valg! Vælg et tal mellem 1 - 9");
                    scanner.nextLine();
                    continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Ukendt valg! Vælg et tal mellem 1 - 9");
                scanner.nextLine();
                continue;
            }

            scanner.nextLine();
            switch (input) {
                case 1: // Tilføj Ordre

                    // Ordretilføjelse sker i steps. Først vælger man en pizza, dernæst størrelse og antal. Dette er en 'OrderLine'
                    // En 'Order' består af en liste af OrderLines. Man kan have så mange OrderLines man ønsker.
                    // Når man er færdig med at lave OrderLines, oplyser man hvornår man ønsker ordren skal være klar,
                    // sit kundenavn på ordren, eventuelle kommentarer og hvis ønsket kan man oplyse sit tlf. nr.

                    System.out.println("-*- 1. Tilføj Ordre -*-");

                    int pizzaNumber = 0;
                    while (true) {
                        System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
                        System.out.println("> Indtast 'menu' for at vise menuen");
                        System.out.println("> Indtast '0' for at annullere ordre");
                        String pizzaChoice = scanner.nextLine();
                        if (pizzaChoice.equalsIgnoreCase("0")) {
                            // ANNULLER ORDRE (VIS STARTSKÆRM)
                            break;
                        } else if (pizzaChoice.equals("menu")) {
                            // VIS MENU METODE
                            break;
                        }
                        try {
                            pizzaNumber = Integer.parseInt(pizzaChoice);
                            if (pizzaNumber < 1 || pizzaNumber > pizzaList.size()) {
                                System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
                            } else {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("> Indtast '1 - " + pizzaList.size() + "' for at vælge pizza");
                        }
                    }
                    String pizzaName = pizzaList.get(pizzaNumber - 1).getName();
                    System.out.println("> '" + pizzaName + "' valgt. Hvilken størrelse skal det være?");

                    String pizzaSize = null;
                    while (true) {
                        System.out.println("> Indtast 'M' for at vælge en mellem pizza");
                        System.out.println("> Indtast 'L' for at vælge en stor pizza");
                        System.out.println("> Indtast '0' for at annullere pizzavalg");
                        String sizeChoice = scanner.nextLine();
                        if (sizeChoice.equals("0")) {
                            // VÆLG NY PIZZA
                            break;
                        }
                        pizzaSize = (sizeChoice.equalsIgnoreCase("L")) ? "large" : (sizeChoice.equalsIgnoreCase("M")) ? "medium" : null;

                        if (pizzaSize != null) {
                            break;
                        }
                    }
                    System.out.println("> " + (pizzaSize.equals("large") ? "Stor" : "Medium") + " '" + pizzaName + "' valgt. Hvor mange skal det være?");

                    int quantity = 0;
                    while (true) {
                        System.out.println("> Indtast '1 - 99' for at vælge antal " + (pizzaSize.equals("large") ? "store" : "medium") + " " + pizzaName);
                        System.out.println("> Indtast '0' for at annullere pizzavalg");
                        String quantityChoice = scanner.nextLine();
                        try {
                            quantity = Integer.parseInt(quantityChoice);
                            if (quantity == 0) {
                                // VÆLG NY PIZZA
                                break;
                            } else if (quantity > 0 && quantity < 100) {
                                break;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("> Prøv igen");
                        }
                    }
                    System.out.println("> " + quantity + " " + (pizzaSize.equals("large") ? "store" : "medium") + " '" + pizzaName + "' valgt. Vil du tilføje flere pizzaer?");

                    ArrayList<OrderLine> orderLines = new ArrayList<>();
                    while (true) {
                        System.out.println("> Indtast '1' for at tilføje en ny pizza");
                        System.out.println("> Indtast '0' for at færdiggøre ordre");
                        String addOrFinishOrderChoice = scanner.nextLine();

                        if (addOrFinishOrderChoice.equals("1")) {
                            orderLines.add(new OrderLine(pizzaList.get(pizzaNumber - 1), pizzaSize, quantity, pizzaList.get(pizzaNumber - 1).getPrice()));
                            // KØR TILFØJ ORDRE METODE FRA TOPPEN IGEN FOR AT LAVE NY PIZZA TIL NY ORDERLINE TIL ORDER
                        } else if (addOrFinishOrderChoice.equals("0")) {
                            break;
                        }
                    }
                    System.out.println("> Hvad tid skal ordren bestilles til? Nuværende tid: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());

                    LocalDateTime orderTime;
                    LocalDateTime pickupTime;
                    while (true) {
                        orderTime = LocalDateTime.now().withSecond(0).withNano(0);

                        System.out.println("> Indtast tid med format: (HH:mm)");
                        System.out.println("> Indtast '0' for at bestille ordren til hurtigst muligt");
                        String requestedPickupTime = scanner.nextLine();

                        if (requestedPickupTime.equals("0")) {
                            pickupTime = LocalDateTime.now().plusMinutes(DEFAULT_ORDER_DELAY_IN_MINUTES); // Default er 15 minutter
                            break;
                        } else {
                            try {
                                requestedPickupTime = requestedPickupTime.replace('.', ':');
                                pickupTime = LocalDateTime.parse(requestedPickupTime, DateTimeFormatter.ofPattern("HH:mm"));
                                pickupTime = orderTime.withHour(pickupTime.getHour()).withMinute(pickupTime.getMinute());

                                if (pickupTime.isBefore(orderTime)) {
                                    System.out.println("> Ordre kan ikke bestilles før nuværende tid. Prøv igen");
                                }
                                break;
                            } catch (DateTimeParseException e) {
                                System.out.println("> Prøv et andet tidspunkt");
                            }
                        }
                    }

                    boolean isPickUpTimeToday = Order.isPickUpTimeToday(orderTime);
                    String pickupTimeMessage;
                    boolean askForPhoneNumber;
                    if (isPickUpTimeToday) {
                        pickupTimeMessage = "Ordren er klar kl. " + pickupTime.getHour() + ":" + String.format("%02d", pickupTime.getMinute());
                        askForPhoneNumber = false;
                    } else {
                        pickupTimeMessage = "Ordren er klar d. " + pickupTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm"));
                        askForPhoneNumber = true;
                    }

                    System.out.println(pickupTimeMessage + ". Hvad skal navnet på ordren være?");
                    String customerName;
                    while (true) {
                        System.out.println("> Indtast '0' for at annullere ordre");
                        customerName = scanner.nextLine();
                        if (customerName.equals("0")) {
                            break;
                        }
                        break;
                    }
                    String customerPhoneNumber = null;
                    if (askForPhoneNumber) {
                        System.out.println("Navn på ordren er '" + customerName + "'. Vil du tilføje telefon nummer på ordren?");
                        System.out.println("> Indtast '0' for ikke at oplyse telefon nummer");
                        customerPhoneNumber = scanner.nextLine().trim();

                        if (customerPhoneNumber.equals("0")) {
                            customerPhoneNumber = null;
                        } else {
                            System.out.println("Telefon nummer på ordren er '" + customerPhoneNumber + "'. Vil du tilføje nogle kommentarer?");
                        }
                    } else {
                        System.out.println("Navn på ordren er '" + customerName + "'. Vil du tilføje en kommentar?");
                    }
                    String customerComment;
                    while (true) {
                        System.out.println("> Indtast kommentar til ordre");
                        System.out.println("> Indtast '0' for ikke at tilføje kommentarer");
                        customerComment = scanner.nextLine();

                        if (customerComment.equals("0")) {
                            break;
                        }
                        break;
                    }

                    Order order = new Order(orderLines, customerName, customerPhoneNumber, orderTime, pickupTime, customerComment);
                    orderList.add(order);

                    System.out.println("Ordre (" + order.getOrderNumber() + ") oprettet " + orderTime.getDayOfMonth() + "/" + orderTime.getMonthValue() + "/" + orderTime.getYear() + " kl. " + orderTime.getHour() + ":" + orderTime.getMinute());
                    for (OrderLine line : orderLines) {
                        System.out.println("Pizza: " + line.getPizza().getName() + " | Størrelse: " + line.getSize() + " | Antal: " + line.getQuantity() + " | Pris: " + line.getOrderLineTotalPrice());
                    }
                    System.out.println("Customer Name: " + order.getCustomerName() + " | Customer Phone Number: " + customerPhoneNumber + " | Pickup Time + " + pickupTime.getDayOfMonth() + "/" + pickupTime.getMonthValue() + "/" + pickupTime.getYear() + " kl. " + pickupTime.getHour() + ":" + String.format("%02d", pickupTime.getMinute()) + " | Customer Comment : " + customerComment);
                    break;

                case 2: // Rediger Ordre

                    break;
                case 3: // Annuller Ordre


                    break;
                case 4: // Færdiggør Ordre

                    break;
                case 5: // Vis Ordreliste
                    System.out.println("> OrdreListe");
                    for (Order orderListing : orderList) {
                        System.out.println(orderListing);
                    }




                    break;
                case 6: // Vis Menu
                    System.out.println("-*- Menukort -*-");
                    for (Pizza pizza : pizzaList) {
                        System.out.println(pizza.getPizzaNum() + ". " + pizza.getName() + " - Pris: " + pizza.getPrice() + "\n Toppings: " + Arrays.toString(pizza.getPizzaToppings()));
                    }
                    System.out.println("-*- Menukort -*-");
                    break;
                case 7: // Vis Ordrehistorik

                    break;
                case 8: // Vis Statistik

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
