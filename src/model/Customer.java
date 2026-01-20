package model;

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
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cant be empty");
        }
        this.name = name;
    }

    public void setBonus(int bonus) {
        if (bonus < 0) {
            throw new IllegalArgumentException("Bonus cant be negative");
        }
        this.bonus = bonus;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public int getBonus() {
        return bonus;
    }

    public boolean isVIP() {
        return bonus > 100;
    }
}