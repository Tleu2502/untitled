public class ClothingItem extends Product {
    private String category;
    private boolean isAvailable;

    public ClothingItem(String name, double price, String category, boolean isAvailable) {
        super(name, price);
        this.category = category;
        this.isAvailable = isAvailable;
    }

    @Override
    public String getInfo() {
        return "Clothing → Category: " + category + (isAvailable ? " (in stock)" : " (sold out)");
    }

    @Override
    public String work() {
        return "You can wear " + getName();
    }
}