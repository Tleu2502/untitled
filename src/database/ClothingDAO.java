package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingDAO {

    public void add(ClothingItem item) {
        String sql =
                "INSERT INTO clothes (id, name, price, brand, type, extra) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setDouble(3, item.getPrice());
            ps.setString(4, item.getBrand());
            ps.setString(5, item.getType());
            ps.setString(6, item.getExtraInfo());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Add clothing error");
        }
    }

    public List<ClothingItem> getByMinPrice(double minPrice) {
        List<ClothingItem> list = new ArrayList<>();
        String sql = "SELECT * FROM clothes WHERE price >= ? ORDER BY price";

        try (Connection c = DatabaseConnection.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setDouble(1, minPrice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                switch (rs.getString("type")) {
                    case "Shirt" -> list.add(new Shirt(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("brand"),
                            rs.getString("extra")
                    ));
                    case "Pants" -> list.add(new Pants(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("brand"),
                            rs.getString("extra")
                    ));
                    case "Jacket" -> list.add(new Jacket(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("brand"),
                            rs.getString("extra")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Search error");
        }
        return list;
    }
}
