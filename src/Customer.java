public class Customer {
    private int customerId;
    private String name;
    private String phoneNumber;
    private int bonus;

    public Customer(int customerId, String name, String phoneNumber, int bonus) {
        this.customerId = customerId;
        setName(name);
        this.phoneNumber = phoneNumber;
        setBonus(bonus);
    }

    public int getCustomerId() { return customerId; }
    public String getName() { return name; }
    public String getPhoneNumber() { return phoneNumber; }
    public int getBonus() { return bonus; }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            this.name = "No Name";
        } else {
            this.name = name;
        }
    }

    public void setBonus(int bonus) {
        if (bonus < 0) {
            this.bonus = 0;
        } else {
            this.bonus = bonus;
        }
    }

    public boolean isVIP() {
        return bonus > 100;
    }
}