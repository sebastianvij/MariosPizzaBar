import javax.xml.namespace.QName;

public class PizzaMenuList {
    private String name;
    private int price;
    private int pNum;
    private String pSize;
    private String pCondiments;

    //Constructor
    public PizzaMenuList(String name, int price, int pNum, String pSize, String pCondiments) {
        this.name=name;
        this.price=price;
        this.pNum=pNum;
        this.pSize=pSize;
        this.pCondiments=pCondiments;
    }
    //Settere og gettere
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setpCondiments(String pCondiments) {
        this.pCondiments = pCondiments;
    }

    public String getpCondiments() {
        return pCondiments;
    }

    public void setpNum(int pNum) {
        this.pNum = pNum;
    }

    public int getpNum() {
        return pNum;
    }

    public void setpSize(String pSize) {
        this.pSize = pSize;
    }

    public String getpSize() {
        return pSize;
    }
}
