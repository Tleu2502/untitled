package menu;

import model.*;
import exception.InvalidInputException;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public MenuManager() {
        products.add(new ClothingItem("T-Shirt", 3500, "Casual"));
        products.add(new Accessory("Belt", 2500, "Leather"));
        customers.add(new Customer(101, "Aliya", "+77051234567", 80));
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== CLOTHING STORE ===");
        System.out.println("1. Add Clothing");
        System.out.println("2. Add Accessory");
        System.out.println("3. View All Products");
        System.out.println("4. Add Customer");
        System.out.println("5. View All Customers");
        System.out.println("0. Exit");
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                if (choice == 1) {
                    addClothing();
                } else if (choice == 2) {
                    addAccessory();
                } else if (choice == 3) {
                    viewProducts();
                } else if (choice == 4) {
                    addCustomer();
                } else if (choice == 5) {
                    viewCustomers();
                } else if (choice == 0) {
                    System.out.println("Bye!");
                    break;
                } else {
                    throw new InvalidInputException("Wrong choice");
                }
            } catch (NumberFormatException e) {
                scanner.nextLine();
                System.out.println("Enter a number please");
            } catch (IllegalArgumentException | InvalidInputException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("\nPress Enter...");
            scanner.nextLine();
        }
        scanner.close();
    }

    private void addClothing() {

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.println("Price: ");
        double price = scanner.nextDouble();

        System.out.print("Category: ");
        String category = scanner.nextLine();

        products.add(new ClothingItem(name, price, category));
        System.out.println("Added!");
    }

    private void addAccessory() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Material: ");
        String material = scanner.nextLine();

        products.add(new Accessory(name, price, material));
        System.out.println("Added!");
    }

    private void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products.");
            return;
        }

        System.out.println("\nAll Products:");
        for (Product p : products) {
            System.out.println(p.getName() + " - " + p.getPrice() + " KZT");
            System.out.println("Type: " + p.getRole());
            System.out.println();
        }
    }

    private void addCustomer() {
        System.out.print("ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        System.out.print("Bonus: ");
        int bonus = scanner.nextInt();
        scanner.nextLine();

        customers.add(new Customer(id, name, phone, bonus));
        System.out.println("Added!");
    }

    private void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }

        System.out.println("\nAll Customers:");
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i + 1) + ". " + c.getName() + " (ID " + c.getId() + ")");
            System.out.println("   Phone: " + c.getPhone());
            System.out.println("   Bonus: " + c.getBonus() + (c.isVIP() ? " (VIP)" : ""));
            System.out.println();
        }
    }
}