
        package menu;

import database.ClothingDAO;
import database.CustomerDAO;
import model.*;

import java.util.Scanner;

public class StoreMenu implements Menu {

    private final Scanner sc = new Scanner(System.in);
    private final ClothingDAO clothingDAO = new ClothingDAO();
    private final CustomerDAO customerDAO = new CustomerDAO();

    @Override
    public void showMenu() {
        System.out.println("""
                ===== URBANWEAR STORE =====
                1. Add Hoodie
                2. Add T-Shirt
                3. Add Jacket
                4. Search Clothes by Min Price
                5. Add Customer
                6. View Customers
                0. Exit
                """);
    }

    @Override
    public void run() {
        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 : addHoodie();
                case 2 : addTShirt();
                case 3 : addJacket();
                case 4 : searchByPrice();
                case 5 : addCustomer();
                case 6 : viewCustomers();
                case 0 : { return; }
                default: System.out.println("Wrong choice");
            }
        }
    }

    private void addHoodie() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Size (S/M/L): ");
        String size = sc.nextLine();

        clothingDAO.addClothing(new Hoodie(name, price, size));
    }

    private void addTShirt() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Color: ");
        String color = sc.nextLine();

        clothingDAO.addClothing(new TShirt(name, price, color));
    }

    private void addJacket() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Season: ");
        String season = sc.nextLine();

        clothingDAO.addClothing(new Jacket(name, price, season));
    }

    private void searchByPrice() {
        System.out.print("Min price: ");
        double min = sc.nextDouble(); sc.nextLine();

        clothingDAO.searchByMinPrice(min)
                .forEach(c ->
                        System.out.println(
                                c.getName() + " | " +
                                        c.getPrice() + " | " +
                                        c.getType()
                        ));
    }

    private void addCustomer() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Bonus: ");
        int bonus = sc.nextInt(); sc.nextLine();

        customerDAO.addCustomer(new Customer(id, name, bonus));
    }

    private void viewCustomers() {
        customerDAO.getAllCustomers()
                .forEach(c ->
                        System.out.println(
                                c.getName() + " | Bonus: " + c.getBonus()
                        ));
    }
}