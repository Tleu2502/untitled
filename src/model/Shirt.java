package model;

public class Shirt extends ClothingItem {

    private String size;

    public Shirt(int id, String name, double price, String brand, String size) {
        super(id, name, price, brand);
        this.size = size;
    }

    @Override
    public String getType() {
        return "Shirt";
    }

    @Override
    public String getExtraInfo() {
        return size;
    }
}
