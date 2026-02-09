package model;

public class TShirt extends Clothing {

    private String color;

    public TShirt(String name, double price, String color) {
        super(name, price);
        this.color = color;
    }

    public String getType() { return "TSHIRT"; }
    public String getDetail() { return color; }
}