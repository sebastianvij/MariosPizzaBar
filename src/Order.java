import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Order {
    // Attributter
    private String customerName;
    private List<OrderLine> orderLines;
    private LocalDateTime pickupTime;
    private String customerComment;

    private int orderNumber;
    private boolean isActive;
    private boolean isPaid;

    private static int orderCounter = 0;

    // Constructor
    public Order(String customerName, List<OrderLine> orderLines, LocalDateTime pickupTime, String customerComment) {
        this.customerName = customerName;
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

    public String getCustomerName() {
        return customerName;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
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
        System.out.println("Indtast navn på bestilling");

        String customerName = scanner.nextLine();

        System.out.println("> Hvad tid skal ordren bestilles til? Nuværende tid: " + LocalDateTime.now().getHour() + ":" + LocalDateTime.now().getMinute());

        String requestedPickupTime = scanner.nextLine();
        LocalDateTime pickupTime;

        int DEFAULT_ORDER_DELAY_IN_MINUTES = 15;

        if (requestedPickupTime.equals("nu")) {
            pickupTime = LocalDateTime.now().plusMinutes(DEFAULT_ORDER_DELAY_IN_MINUTES); // Default er 15 minutter
        } else {
            requestedPickupTime = requestedPickupTime.replace('.', ':');
            pickupTime = LocalDateTime.parse(requestedPickupTime, DateTimeFormatter.ofPattern("HH:mm"));
        }
        System.out.println("Yderlige kommentarer");

        String customerComment = scanner.nextLine();

        Order order = new Order(customerName, orderLines, pickupTime, customerComment);
        Order.printReceipt(order);
        OrderArchive.addOrderToArchive(order);
    }

    public static void printOrderLines(Order order) {
        int count = 1;
        for (OrderLine orderLine : order.getOrderLines()) {
            System.out.println(count + ". " + orderLine.getQuantity() + "   x   " + orderLine.getSize() + " " + orderLine.getPizza().getName() + "       " + orderLine.getPizza().getUnitPrice() * orderLine.getQuantity());
            count++;
        }
    }

    public static void printReceipt(Order order) {
        System.out.println("--- Marios Pizzabar ---");
        System.out.println(order.getOrderNumber());
        System.out.println("Kunde: " + order.getCustomerName());
        System.out.println("Afhentning: " + order.getPickupTime());

        System.out.println("Antal " + "Pizza " + "Total");
        System.out.println("---- " + "-------------- " + "---------");
        printOrderLines(order);
        System.out.println("Total Price: " + order.getOrderTotalPrice() + " kr.");
    }
}