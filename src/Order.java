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

        System.out.println("Indtast en kommentar");
        System.out.println("> 0. For ikke at tilføje en kommentar");

        String customerComment = scanner.nextLine();

        if (customerComment.equals("0")) {
            customerComment = null;
        }
        Order order = new Order(orderLines, pickupTime, customerComment);
        System.out.println("Ordre oprettet! Udskriver kvittering...");
        System.out.println();
        Order.printReceipt(order);
        OrderArchive.addOrderToArchive(order);
    }

    public static void printReceipt(Order order) {
        System.out.println("Order #" + order.getOrderNumber() + " | Til Afhentning: " + order.getPickupTime().withSecond(0).withNano(0));
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
