package database;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void add(Customer c) {
        String sql =
                "INSERT INTO customers (id, name, phone, bonus) VALUES (?, ?, ?, ?)";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setInt(4, c.getBonusPoints());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Add customer error");
        }
    }

    public List<Customer> getAll() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("phone"),
                        rs.getInt("bonus")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Load error");
        }
        return list;
    }
}
