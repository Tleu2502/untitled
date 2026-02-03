package database;

import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CustomerDAO {

    public void addCustomer(Customer c) {

        String sql = """
                INSERT INTO customers (id, name, phone, bonus)
                VALUES (?, ?, ?, ?)
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, c.getId());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPhone());
            ps.setInt(4, c.getBonus());

            ps.executeUpdate();
            System.out.println("Customer saved");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean updateCustomer(int id, String name, String phone, int bonus) {

        String sql = """
                UPDATE customers
                SET name = ?, phone = ?, bonus = ?
                WHERE id = ?
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setInt(3, bonus);
            ps.setInt(4, id);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ========== DELETE ==========
    public boolean deleteCustomerById(int id) {

        String sql = "DELETE FROM customers WHERE id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // ========== SEARCH BY NAME ==========
    public void searchCustomerByName(String name) {

        String sql = """
                SELECT * FROM customers
                WHERE name ILIKE ?
                ORDER BY name
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + name + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") +
                                ", Name: " + rs.getString("name") +
                                ", Phone: " + rs.getString("phone") +
                                ", Bonus: " + rs.getInt("bonus")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void searchCustomerByBonusRange(int min, int max) {

        String sql = """
                SELECT * FROM customers
                WHERE bonus BETWEEN ? AND ?
                ORDER BY bonus DESC
                """;

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, min);
            ps.setInt(2, max);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        "Name: " + rs.getString("name") +
                                ", Bonus: " + rs.getInt("bonus")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}