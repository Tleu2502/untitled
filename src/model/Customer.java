package model;

import exception.InvalidInputException;

public class Customer {

    private int id;
    private String name;
    private int bonus;

    public Customer(int id, String name, int bonus) {
        if (bonus < 0)
            throw new InvalidInputException("Negative bonus");

        this.id = id;
        this.name = name;
        this.bonus = bonus;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getBonus() { return bonus; }
}