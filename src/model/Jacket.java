package model;

public class Jacket extends Clothing {

    private String season;

    public Jacket(int id, String name, double price, String brand, String season) {
        super(id, name, price, brand);
        this.season = season;
    }

    @Override
    public String getType() {
        return "Jacket";
    }

    @Override
    public String getExtraInfo() {
        return season;




    }
}