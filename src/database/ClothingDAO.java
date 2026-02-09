 package database;

import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClothingDAO {

    public void addClothing(Clothing c) {
        String sql =
                "INSERT INTO clothes (name, price, type, detail) VALUES (?, ?, ?, ?)";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setString(1, c.getName());
            ps.setDouble(2, c.getPrice());
            ps.setString(3, c.getType());
            ps.setString(4, c.getDetail());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Add clothing error");
        }
    }

    public List<Clothing> searchByMinPrice(double minPrice) {
        List<Clothing> list = new ArrayList<>();
        String sql =
                "SELECT * FROM clothes WHERE price >= ? ORDER BY price";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setDouble(1, minPrice);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                switch (rs.getString("type")) {
                    case 1 : list.add(new Hoodie(
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("detail")
                    ));
                    case 2: list.add(new TShirt(
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("detail")
                    ));
                    case 3 : list.add(new Jacket(
                            rs.getString("name"),
                            rs.getDouble("price"),
                            rs.getString("detail")
                    ));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Search error");
        }
        return list;
    }
}