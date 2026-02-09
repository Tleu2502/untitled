package model;

import exception.InvalidInputException;

public abstract class ClothingItem {

    protected int id;
    protected String name;
    protected double price;
    protected String brand;

    public ClothingItem(int id, String name, double price, String brand) {
        setId(id);
        setName(name);
        setPrice(price);
        setBrand(brand);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }

    public void setId(int id) {
        if (id <= 0) throw new InvalidInputException("Invalid ID");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Empty name");
        this.name = name;
    }

    public void setPrice(double price) {
        if (price < 0)
            throw new InvalidInputException("Negative price");
        this.price = price;
    }

    public void setBrand(String brand) {
        if (brand == null || brand.isBlank())
            throw new InvalidInputException("Empty brand");
        this.brand = brand;
    }

    public abstract String getType();
    public abstract String getExtraInfo();

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + brand + " | " + getType();
    }
}
