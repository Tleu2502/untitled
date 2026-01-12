public class Customer {
    private int id;
    private String name;
    private String phone;
    private int bonus;

    public Customer(int id, String name, String phone, int bonus) {
        this.id = id;
        setName(name);
        this.phone = phone;
        setBonus(bonus);
    }

    public void setName(String name) {
        this.name = (name == null || name.trim().isEmpty()) ? "No Name" : name;
    }

    public void setBonus(int bonus) {
        this.bonus = (bonus < 0) ? 0 : bonus;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getBonus() { return bonus; }

    public boolean isVIP() {
        return bonus > 100;
    }
}