package GAMMEL;

import java.util.List;

public class OrderArchiveGAMMEL {
    // Vores statistik skal bestå af et ArrayList som holder alle vores ordre(Ordrehistorik).
    // Det skal bestå af isPaid og IsActive getter metoder så vi kan differenciere mellem typer af ordre.

    private OrderGAMMEL orderGAMMEL;
    private boolean isPaid;
    private boolean isActive;
    private List<OrderArchiveGAMMEL> orderArchiveGAMMELList;

    public OrderArchiveGAMMEL(OrderGAMMEL orderGAMMEL, boolean isPaid, boolean isActive) {
        this.orderGAMMEL = orderGAMMEL;
        this.isPaid = isPaid;
        this.isActive = isActive;
    }

    public OrderGAMMEL getOrder() {
        return orderGAMMEL;
    }

    public void setOrderArchive(OrderGAMMEL orderGAMMEL) {
        this.orderGAMMEL = orderGAMMEL;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }



    /* public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderArchive orderArchive = (OrderArchive) o;
        return Objects.equals(isActive, orderArchive.isActive) && Objects.equals(isPaid, orderArchive.isPaid);
    }
*/
    public static void mostPopularPizza() {


    }
}
