package database;

import model.Customer;
import java.sql.*;

public class CustomerDAO {

    public void addCustomer(Customer c) {
        String sql =
                "INSERT INTO customers (id, name, phone, bonus) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setInt(4, c.getBonus());

            ps.executeUpdate();
            System.out.println("CUSTOMER SAVED");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}