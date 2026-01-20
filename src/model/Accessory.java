package model;

public class Accessory extends Product {
    private String material;

    public Accessory(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public String getRole() {
        return "Accessory";
    }
}