 package database;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {

    public void addCustomer(Customer c) {
        String sql =
                "INSERT INTO customers (id, name, bonus) VALUES (?, ?, ?)";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setInt(3, c.getBonus());
            ps.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Add customer error");
        }
    }

    public List<Customer> getAllCustomers() {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM customers";

        try (Connection cn = DatabaseConnection.getConnection();
             PreparedStatement ps = cn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Customer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("bonus")
                ));
            }

        } catch (SQLException e) {
            throw new RuntimeException("Load customers error");
        }
        return list;
    }
}