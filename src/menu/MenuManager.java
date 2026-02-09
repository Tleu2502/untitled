package menu;

import database.ClothingDAO;
import database.CustomerDAO;
import model.*;

import java.util.Scanner;

public class MenuManager {

    private final Scanner sc = new Scanner(System.in);
    private final ClothingDAO clothingDAO = new ClothingDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();

    public void run() {
        while (true) {
            System.out.println("""
                    ==== CLOTHING STORE ====
                    1. Add Shirt
                    2. Add Pants
                    3. Add Jacket
                    4. Search Clothes by Min Price
                    5. Add Customer
                    6. View Customers
                    0. Exit
                    """);

            int c = sc.nextInt();
            sc.nextLine();

            switch (c) {
                case 1 -> addShirt();
                case 2 -> addPants();
                case 3 -> addJacket();
                case 4 -> searchByPrice();
                case 5 -> addCustomer();
                case 6 -> viewCustomers();
                case 0 -> { return; }
            }
        }
    }

    private void addShirt() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Size: ");
        String size = sc.nextLine();

        clothingDAO.add(new Shirt(id, name, price, brand, size));
    }

    private void addPants() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Fit: ");
        String fit = sc.nextLine();

        clothingDAO.add(new Pants(id, name, price, brand, fit));
    }

    private void addJacket() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Brand: ");
        String brand = sc.nextLine();
        System.out.print("Season: ");
        String season = sc.nextLine();

        clothingDAO.add(new Jacket(id, name, price, brand, season));
    }

    private void searchByPrice() {
        System.out.print("Min price: ");
        double min = sc.nextDouble(); sc.nextLine();

        clothingDAO.getByMinPrice(min)
                .forEach(System.out::println);
    }

    private void addCustomer() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Bonus: ");
        int bonus = sc.nextInt(); sc.nextLine();

        customerDAO.add(new Customer(id, name, phone, bonus));
    }

    private void viewCustomers() {
        customerDAO.getAll()
                .forEach(System.out::println);
    }
}
