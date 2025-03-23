import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderArchive {
    // Vores statistik skal bestå af et ArrayList som holder alle vores ordre(Ordrehistorik).
    // Det skal bestå af isPaid og IsActive getter metoder så vi kan differenciere mellem typer af ordre.

    private Order orderArchive;
    private boolean isPaid;
    private boolean isActive;

    public OrderArchive (Order orderArchive, boolean isPaid, boolean isActive) {
        this.orderArchive = orderArchive;
        this.isPaid = isPaid;
        this.isActive = isActive;
    }



    public Order getOrderArchive() {
        return orderArchive;
    }

    public void setOrderArchive(Order orderArchive) {
        this.orderArchive = orderArchive;
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


}
