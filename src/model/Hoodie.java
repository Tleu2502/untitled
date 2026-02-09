
package model;

public class Hoodie extends Clothing {

    private String size;

    public Hoodie(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }

    public String getType() {
        return "HOODIE";
    }
    public String getDetail() {
        return size;
    }
}