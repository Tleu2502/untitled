package model;

public class ClothingItem extends Product {
    private String category;

    public ClothingItem(String name, double price, String category) {
        super(name, price);
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String getRole() {
        return "Clothing";
    }
}