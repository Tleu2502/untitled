public class ClothingItem {
    private String name;
    private double price;
    private String category;
    private boolean isAvailable;

    public ClothingItem(String name, double price, String category, boolean isAvailable) {
        setName(name);
        setPrice(price);
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return isAvailable; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "No Name";
        } else {
            this.name = name;
        }
    }

    public void setPrice(double price) {
        if (price < 0) {
            this.price = 0;
        } else {
            this.price = price;
        }
    }
}