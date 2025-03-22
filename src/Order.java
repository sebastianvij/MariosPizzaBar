import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private List<OrderLine> orderLineList;
    private String customerName;
    private LocalDateTime orderTime;
    private LocalDateTime pickupTime;
    private String customerPhoneNumber; // Optional
    private String customerComment;
    private final int orderNumber;

    private static int orderCounter = 0;

    // Constructor
    public Order(List<OrderLine> orderLineList, String customerName, String customerPhoneNumber, LocalDateTime orderTime, LocalDateTime pickupTime, String customerComment) {
        this.orderLineList = orderLineList;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.customerComment = customerComment;
        this.orderNumber = ++orderCounter;
    }

    // Setters & Getters
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setPickupTime(LocalDateTime pickupTime) {
        this.pickupTime = pickupTime;
    }

    public LocalDateTime getPickupTime() {
        return pickupTime;
    }

    public void setCustomerComment(String customerComment) {
        this.customerComment = customerComment;
    }

    public String getCustomerComment() {
        return customerComment;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public int getOrderTotalPrice() {
        int totalPrice = 0;
        for (OrderLine line : orderLineList) {
            totalPrice += line.getOrderLineTotalPrice();
        }
        return totalPrice;
    }

    public static boolean isPickUpTimeToday(LocalDateTime pickupTime) {
        return pickupTime.toLocalDate().isEqual(LocalDate.now());
    }

    @Override
    public String toString() {
        return "Order id: " + orderNumber + " , Customer: " + customerName + " , PickupTime: " + pickupTime;
    }
}

