import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
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
            totalPrice += orderLine.getOrderLineTotalPrice();
        }
        return totalPrice;
    }

    public static void createOrder(Scanner scanner, List<OrderLine> orderLines) {

        LocalDateTime pickupTime;
        int day = LocalDateTime.now().getDayOfMonth();
        int month = LocalDateTime.now().getMonthValue();
        int year = LocalDateTime.now().getYear();
        int pickupTimeHour = LocalDateTime.now().getHour();
        int pickupTimeMinutes = LocalDateTime.now().getMinute();

        while (true) {
            pickupTime = LocalDateTime.now().withSecond(0).withNano(0);
            System.out.println("Hvad tid skal ordren bestilles til? Nuværende tid: " + pickupTimeHour + ":" + pickupTimeMinutes);
            System.out.println("> 1. 'Hurtigst muligt'");
            System.out.println("> 2. 'Bestem tidspunkt'");
            System.out.println("> 0. 'Returner til menu'");

            int pickUpInput = scanner.nextInt();
            scanner.nextLine();

            if (pickUpInput == 0) {
                return; // Afbryd metoden
            }

            int DEFAULT_ORDER_DELAY_IN_MINUTES = 15;

            if (pickUpInput == 1) {
                pickupTime = LocalDateTime.now().plusMinutes(DEFAULT_ORDER_DELAY_IN_MINUTES);
                break;
            } else if (pickUpInput == 2) {
                int pickUpTimeDay;
                while (true) {
                    System.out.println("Skal ordren hentes i dag?");
                    System.out.println("> 1. 'I dag'");
                    System.out.println("> 2. 'Vælg anden dag'");
                    pickUpTimeDay = scanner.nextInt();
                    scanner.nextLine();
                    if (pickUpTimeDay == 1) {
                        break;
                    } else if (pickUpTimeDay == 2) {
                        while (true) {
                            System.out.println("Indtast ønsket afhentningsdato (dag 1-31): ");
                            day = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Indtast ønsket måned (1-12): ");
                            month = scanner.nextInt();
                            scanner.nextLine();
                            System.out.println("Indtast ønsket år (20XX): ");
                            year = scanner.nextInt();
                            scanner.nextLine();

                            int maxDaysInMonth = YearMonth.of(year, month).lengthOfMonth();
                            if (day >= 1 && day <= maxDaysInMonth && month >= 1 && month <= 12 && year >= 2025) {
                                break;
                            } else {
                                System.out.println("Ugyldig dato! Prøv igen.");
                            }
                        }
                        break;
                    } else {
                        System.out.println("Ugyldigt input! Prøv igen.");
                    }
                }

                while (true) {
                    System.out.println("Hvornår skal ordren afhentes? Skriv timetal (0-23):");
                    pickupTimeHour = scanner.nextInt();
                    scanner.nextLine();
                    if (pickupTimeHour >= 0 && pickupTimeHour < 24) {
                        break;
                    } else {
                        System.out.println("Ugyldigt input! Prøv igen.");
                    }
                }

                while (true) {
                    System.out.println("Hvornår skal ordren afhentes? Skriv minuttal (0-59):");
                    pickupTimeMinutes = scanner.nextInt();
                    scanner.nextLine();
                    if (pickupTimeMinutes >= 0 && pickupTimeMinutes < 60) {
                        break;
                    } else {
                        System.out.println("Ugyldigt input! Prøv igen.");
                    }
                }
                pickupTime = LocalDateTime.of(year, month, day, pickupTimeHour, pickupTimeMinutes).withSecond(0).withNano(0);
                break;
            }
        }

        System.out.println("Tilføj en kommentar");

        String customerComment = scanner.nextLine();

        Order order = new Order(orderLines, pickupTime, customerComment);
        Order.printReceipt(order);
        OrderArchive.addOrderToArchive(order);
    }

    public static void printReceipt(Order order) {
        System.out.println("Order #" + order.getOrderNumber() + " | Til Afhentning: " + order.getPickupTime().withSecond(0).withNano(0));
        printOrderLines(order);
        System.out.println("Kommentar: " + order.getCustomerComment());
        System.out.println("Total Price: " + order.getOrderTotalPrice() + " DKK.");
    }

    public static void printOrderLines(Order order) {
        int count = 1;
        for (OrderLine orderLine : order.getOrderLines()) {
            System.out.println(count + ". " + orderLine.getQuantity() + "   x   " + orderLine.getSize() + " " + orderLine.getPizza().getName() + "       " + orderLine.getOrderLineTotalPrice() + " DKK");
            count++;
        }
    }
}
