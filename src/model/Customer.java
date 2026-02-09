package model;

import exception.InvalidInputException;

public class Customer {

    private int id;
    private String name;
    private String phone;
    private int bonusPoints;

    public Customer(int id, String name, String phone, int bonusPoints) {
        setId(id);
        setName(name);
        setPhone(phone);
        setBonusPoints(bonusPoints);
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public int getBonusPoints() { return bonusPoints; }

    public void setId(int id) {
        if (id <= 0) throw new InvalidInputException("Invalid ID");
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.isBlank())
            throw new InvalidInputException("Empty name");
        this.name = name;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.isBlank())
            throw new InvalidInputException("Empty phone");
        this.phone = phone;
    }

    public void setBonusPoints(int bonusPoints) {
        if (bonusPoints < 0)
            throw new InvalidInputException("Negative bonus");
        this.bonusPoints = bonusPoints;
    }

    public boolean isVIP() {
        return bonusPoints >= 100;
    }

    @Override
    public String toString() {
        return id + " | " + name + " | " + phone + " | bonus=" + bonusPoints;
    }
}
