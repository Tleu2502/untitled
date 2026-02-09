package model;

import exception.InvalidInputException;

public abstract class Clothing {

    protected int id;
    protected String name;
    protected double price;
    protected String brand;

    public Clothing(int id, String name, double price, String brand) {
        if (id <= 0) throw new InvalidInputException("Invalid ID");
        if (name == null || name.isBlank()) throw new InvalidInputException("Empty name");
        if (price < 0) throw new InvalidInputException("Negative price");
        if (brand == null || brand.isBlank()) throw new InvalidInputException("Empty brand");

        this.id = id;
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getBrand() { return brand; }

    public abstract String getType();
    public abstract String getExtraInfo();

    @Override
    public String toString() {
        return id + " | " + name + " | " + price + " | " + brand + " | " + getType();
    }
}