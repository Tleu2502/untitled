package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:postgresql://localhost:5432/clothing_store_db";
    private static final String USER = "postgres";
    private static final String PASSWORD = "192837465";

    public static Connection getConnection() {
        try {
            Connection conn =
                    DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("CONNECTED TO DB");
            return conn;
        } catch (Exception e) {
            System.out.println("DB ERROR");
            e.printStackTrace();
            return null;
        }
    }
}