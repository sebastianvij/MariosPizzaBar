import java.time.LocalDateTime;

public class Order {

    private String name;
    private LocalDateTime orderTime;
    private LocalDateTime pickupTime;
    private String phoneNumber; // Optional
    private String customerComment;

    // Main Constructor
    public Order(String name, String phoneNumber, LocalDateTime orderTime, LocalDateTime pickupTime, String customerComment) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.orderTime = orderTime;
        this.pickupTime = pickupTime;
        this.customerComment = customerComment;
    }

    // Constructor uden telefonnummer
    public Order(String name, LocalDateTime orderTime, LocalDateTime pickupTime, String customerComment) {
        this(name, null, orderTime, pickupTime, customerComment);
    }

    // Setters & Getters
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
