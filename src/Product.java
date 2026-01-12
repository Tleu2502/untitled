public abstract class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        setName(name);
        setPrice(price);
    }

    public void setName(String name) {
        this.name = (name == null || name.trim().isEmpty()) ? "No Name" : name;
    }

    public void setPrice(double price) {
        this.price = (price < 0) ? 0 : price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getInfo();

    public String work() {
        return "In Processing ";
    }
}