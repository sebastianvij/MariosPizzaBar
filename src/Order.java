import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Scanner;

public class Order {
    // Attributter
    private List<OrderLine> orderLines;
    private LocalDateTime pickupTime;
    private String customerComment;

    private int orderNumber;
    private boolean isActive;
    private boolean isPaid;

    private static int orderCounter = 0;

    // Constructor
    public Order(List<OrderLine> orderLines, LocalDateTime pickupTime, String customerComment) {
        this.orderLines = orderLines;
        this.pickupTime = pickupTime;
        this.customerComment = customerComment;
        this.orderNumber = ++orderCounter;
        this.isActive = true;
        this.isPaid = true;
    }

    // Getters & Setters
    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public List<OrderLine> getOrderLines() {
        return orderLines;
    }

    public void setOrderLines(List<OrderLine> orderLines) {
        this.orderLines = orderLines;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setComplete() {
        OrderArchive.removeOrderFromActiveOrder(this);
        this.isActive = false;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void markAsPaid() {
        this.isPaid = true;
    }

    public void cancelOrder() {
        this.isActive = false;
        this.isPaid = false;
    }

    public int getOrderTotalPrice() {
        int totalPrice = 0;
        for (OrderLine orderLine : orderLines) {
            totalPrice += orderLine.calculateOrderLineTotalPrice(orderLine);
        }
        return totalPrice;
    }

    public static void createOrder(Scanner scanner, List<OrderLine> orderLines) {

        LocalDateTime pickupTime = setPickUpTime(scanner);

        System.out.println("Indtast en kommentar til ordren");
        System.out.println("> 0. For ikke at tilføje en kommentar");

        String customerComment = scanner.nextLine();

        if (customerComment.equals("0")) {
            customerComment = "";
        }
        Order order = new Order(orderLines, pickupTime, customerComment);
        System.out.println("Ordre oprettet! Udskriver kvittering...\n");
        Order.printReceipt(order);
        System.out.println();
        OrderArchive.addOrderToArchive(order);
    }

    public static LocalDateTime setPickUpTime(Scanner scanner) {
        int DEFAULT_ORDER_DELAY_IN_MINUTES = 15;
        int day = LocalDateTime.now().getDayOfMonth();
        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();
        int pickupTimeHour = LocalDateTime.now().getHour();
        int pickupTimeMinutes = LocalDateTime.now().getMinute();

        while (true) {
            System.out.println("Hvornår skal ordren afhentes? Nuværende tid: " + pickupTimeHour + ":" + pickupTimeMinutes);
            System.out.println("> 1. Hurtigst muligt (" + DEFAULT_ORDER_DELAY_IN_MINUTES + " min.)");
            System.out.println("> 2. Vælg tidspunkt");
            System.out.println("> 0. Annuller ordre");

            String pickUpInput = scanner.nextLine();

            if (pickUpInput.equals("0")) {
                System.out.println("Ordre annulleret");
                Main.returnToMainMenuPrompt(scanner);
                return null;
            }

            if (pickUpInput.equals("1")) {
                return LocalDateTime.now().plusMinutes(DEFAULT_ORDER_DELAY_IN_MINUTES);
            } else if (pickUpInput.equals("2")) {
                while (true) {
                    System.out.println("Skal ordren hentes i dag?");
                    System.out.println("> 1. I dag");
                    System.out.println("> 2. Vælg anden dag");
                    System.out.println("> 0. Annuller ordre");

                    String input = scanner.nextLine();

                    if (input.equals("0")) {
                        System.out.println("Ordre annulleret");
                        Main.returnToMainMenuPrompt(scanner);
                    }

                    if (input.equals("1")) {
                        break;
                    } else if (input.equals("2")) {
                        while (true) {
                            try {
                                System.out.println("Indtast ønsket afhentningsdato (dag 1-31):");
                                day = Integer.parseInt(scanner.nextLine());

                                if (day < 1 || day > 31) {
                                    System.out.println("Ugyldigt input! Prøv igen");
                                    continue;
                                }

                                System.out.println("Indtast ønsket måned (1-12):");
                                month = Integer.parseInt(scanner.nextLine());

                                if (month < 1 || month > 12) {
                                    System.out.println("Ugyldigt input! Prøv igen");
                                    continue;
                                }

                                System.out.println("Indtast ønsket år (" + LocalDateTime.now().getYear() + "-" + (LocalDateTime.now().getYear() + 1) + "):");
                                year = Integer.parseInt(scanner.nextLine());

                                if (year < 2025 || year > 2035 || year < LocalDateTime.now().getYear()) {
                                    System.out.println("Ugyldigt input! Prøv igen");
                                    continue;
                                }

                                int maxDaysInMonth = YearMonth.of(year, month).lengthOfMonth();
                                if (day <= maxDaysInMonth) {
                                    break;
                                } else {
                                    System.out.println("Ugyldigt input! Prøv igen");
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Ugyldigt input! Prøv igen");
                            }
                        }
                        break;
                    }
                    System.out.println("Ugyldigt input! Prøv igen");
                }

                while (true) {
                    try {
                        System.out.println("Hvornår skal ordren afhentes? Skriv timetal (0-23):");
                        pickupTimeHour = Integer.parseInt(scanner.nextLine());

                        if (pickupTimeHour >= 0 && pickupTimeHour < 24) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldigt input! Prøv igen");
                    }
                }

                while (true) {
                    try {
                        System.out.println("Hvornår skal ordren afhentes? Skriv minuttal (0-59):");
                        pickupTimeMinutes = Integer.parseInt(scanner.nextLine());

                        if (pickupTimeMinutes >= 0 && pickupTimeMinutes < 60) {
                            break;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Ugyldigt input! Prøv igen");
                    }
                }
                return LocalDateTime.of(year, month, day, pickupTimeHour, pickupTimeMinutes).withSecond(0).withNano(0);
            }
            System.out.println("Ugyldigt input! Prøv igen");
        }
    }

    public static void printReceipt(Order order) {
        System.out.println("Ordrenummer: #" + order.getOrderNumber() + " | Afhentningstid: " + order.getPickupTime().withSecond(0).withNano(0));
        printOrderLines(order);
        System.out.println("Kommentar: " + order.getCustomerComment());
        System.out.println("Total Price: " + order.getOrderTotalPrice() + " DKK");
    }

    public static void printOrderLines(Order order) {
        int count = 1;
        for (OrderLine orderLine : order.getOrderLines()) {
            System.out.println(count + ". [" + orderLine.getQuantity() + " x " + orderLine.getSize() + " " + orderLine.getPizza().getName() + " " + orderLine.calculateOrderLineTotalPrice(orderLine) + " DKK]");
            count++;
        }
    }
}
