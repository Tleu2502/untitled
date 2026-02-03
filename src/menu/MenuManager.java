package menu;

import database.CustomerDAO;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private CustomerDAO customerDAO = new CustomerDAO();

    public MenuManager() {
        products.add(new ClothingItem("T-Shirt", 3500, "Casual"));
        products.add(new Accessory("Belt", 2500, "Leather"));
        customers.add(new Customer(101, "Aliya", "+77051234567", 80));
    }

    @Override
    public void displayMenu() {
        System.out.println("""
                     / CLOTHING STORE /
                1. Add Clothing
                2. Add Accessory
                3. View All Products
                4. Add Customer
                5. View All Customers
                6. Update Customer
                7. Delete Customer
                8. Search Customer by Name
                9. Search Customer by Bonus Range
                0. Exit
                """);
        System.out.print("Choice: ");
    }

    @Override
    public void run() {
        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:addClothing();
                    case 2: addAccessory();
                    case 3: viewProducts();
                    case 4: addCustomer();
                    case 5: viewCustomers();
                    case 6: updateCustomer();
                    case 7 : deleteCustomer();
                    case 8: searchCustomerByName();
                    case 9: searchCustomerByBonusRange();
                    case 0: {
                        System.out.println("Good Bye!");
                        return;
                    }
                    default : System.out.println("Wrong choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
        }
    }


    private void addClothing() {
        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

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

        Customer customer = new Customer(id, name, phone, bonus);
        customerDAO.addCustomer(customer);
        customers.add(customer);

        System.out.println("Customer added");
    }

    private void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }

        for (Customer c : customers) {
            System.out.println(
                    c.getName() +
                            " (ID " + c.getId() + "), Bonus: " + c.getBonus() +
                            (c.isVIP() ? " [VIP]" : "")
            );
        }
    }

    private void updateCustomer() {
        System.out.print("Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("New name: ");
        String name = scanner.nextLine();

        System.out.print("New phone: ");
        String phone = scanner.nextLine();

        System.out.print("New bonus: ");
        int bonus = scanner.nextInt();
        scanner.nextLine();

        if (customerDAO.updateCustomer(id, name, phone, bonus))
            System.out.println("Updated");
        else
            System.out.println("Customer not found");
    }

    private void deleteCustomer() {
        System.out.print("Customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Are you sure? (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Cancelled");
            return;
        }

        if (customerDAO.deleteCustomerById(id))
            System.out.println("Deleted");
        else
            System.out.println("Customer not found");
    }

    private void searchCustomerByName() {
        System.out.print("Name: ");
        customerDAO.searchCustomerByName(scanner.nextLine());
    }

    private void searchCustomerByBonusRange() {
        System.out.print("Min bonus: ");
        int min = scanner.nextInt();

        System.out.print("Max bonus: ");
        int max = scanner.nextInt();
        scanner.nextLine();

        customerDAO.searchCustomerByBonusRange(min, max);
    }
}
