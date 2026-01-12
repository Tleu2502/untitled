public class Accessory extends Product {
    private String material;

    public Accessory(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    @Override
    public String getInfo() {
        return "Accessory → Material: " + material;
    }

    @Override
    public String work() {
        return "You can use " + getName() + " as accessory";
    }
}