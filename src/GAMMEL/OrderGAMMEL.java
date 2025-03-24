package GAMMEL;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderGAMMEL {
    //OrderArchive orderArchive = new OrderArchive();
    public static List<OrderGAMMEL> orderGAMMELList = new ArrayList<>();
    private List<OrderLineGAMMEL> orderLineGAMMELList;
    private String customerName;
    private LocalDateTime orderTime;
    private LocalDateTime pickupTime;
    private String customerPhoneNumber; // Optional
    private String customerComment;
    private final int orderNumber;

    private static int orderCounter = 0;
    private static final int DEFAULT_ORDER_DELAY_IN_MINUTES = 15;

    // Constructor
    public OrderGAMMEL(List<OrderLineGAMMEL> orderLineGAMMELList, String customerName, String customerPhoneNumber, LocalDateTime orderTime, LocalDateTime pickupTime, String customerComment) {
        this.orderLineGAMMELList = orderLineGAMMELList;
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
        for (OrderLineGAMMEL line : orderLineGAMMELList) {
            totalPrice += line.getOrderLineTotalPrice();
        }
        return totalPrice;
    }

    public static boolean isPickUpTimeToday(LocalDateTime pickupTime) {
        return pickupTime.toLocalDate().isEqual(LocalDate.now());
    }

    public static OrderGAMMEL custommerInformation(Scanner scanner, ArrayList<OrderLineGAMMEL> orderLineGAMMELS) {
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

        boolean isPickUpTimeToday = OrderGAMMEL.isPickUpTimeToday(orderTime);
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
        System.out.println("> Indtast '0' for at annullere ordre");
        String customerName = scanner.nextLine();
        if (customerName.equals("0")) {
        }

        String customerPhoneNumber = null;
        if (askForPhoneNumber) {
            System.out.println("Navn på ordren er '" + customerName + "'. Vil du tilføje telefon nummer på ordren?");
            System.out.println("> Indtast '0' for ikke at oplyse telefon nummer");
            customerPhoneNumber = scanner.nextLine().trim();

            if (customerPhoneNumber.equals("0")) {
                customerPhoneNumber = null;
            } else {
                System.out.println("Telefon nummer på ordren er '" + customerPhoneNumber + "'. Indtast kommentar til ordren");
            }
        } else {
            System.out.println("Navn på ordren er '" + customerName + "'. Indtast kommentar til ordren");
        }
        System.out.println("> Indtast '0' for ikke at tilføje kommentarer");

        String customerComment = scanner.nextLine();
        if (customerComment.equals("0")) {
            customerComment = null;
        }

        OrderGAMMEL orderGAMMEL = new OrderGAMMEL(orderLineGAMMELS, customerName, customerPhoneNumber, orderTime, pickupTime, customerComment);
        orderGAMMELList.add(orderGAMMEL); // tilføjer til orderlines array

        System.out.println("Ordre (" + orderGAMMEL.getOrderNumber() + ") oprettet " + orderTime.getDayOfMonth() + "/" + orderTime.getMonthValue() + "/" + orderTime.getYear() + " kl. " + orderTime.getHour() + ":" + orderTime.getMinute());
        for (OrderLineGAMMEL line : orderLineGAMMELS) {
            System.out.println("Pizza: " + line.getPizza().getName() + " | Størrelse: " + line.getSize() + " | Antal: " + line.getQuantity() + " | Pris: " + line.getOrderLineTotalPrice());
        }
        System.out.println("Customer Name: " + orderGAMMEL.getCustomerName() + " | Customer Phone Number: " + customerPhoneNumber + " | Pickup Time + " + pickupTime.getDayOfMonth() + "/" + pickupTime.getMonthValue() + "/" + pickupTime.getYear() + " kl. " + pickupTime.getHour() + ":" + String.format("%02d", pickupTime.getMinute()) + " | Customer Comment : " + customerComment);
        return orderGAMMEL;
    }

    @Override
    public String toString() {
        return "Order id: " + orderNumber + " , Customer: " + customerName + " , PickupTime: " + pickupTime + " PizzaType: "+ "Price: " + getOrderTotalPrice(); //tilføj pizza getter
    }

    public static void showOrderList() {
        System.out.println("> OrdreListe");
        for (OrderGAMMEL orderGAMMELListing : orderGAMMELList) {
            System.out.println(orderGAMMELListing);
        }

    }
}

