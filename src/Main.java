import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        products.add(new ClothingItem("T-Shirt", 3500, "Casual", true));
        products.add(new ClothingItem("Jeans", 9000, "Denim", true));
        products.add(new Accessory("Belt", 2500, "Leather"));
        products.add(new Accessory("Scarf", 1800, "Wool"));

        customers.add(new Customer(101, "Ainur", "+77001112233", 60));
        customers.add(new Customer(102, "Madina", "+77775554433", 180));

        while (true) {
            showMenu();
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) addClothing();
            else if (choice == 2) addAccessory();
            else if (choice == 3) viewProducts();
            else if (choice == 4) addCustomer();
            else if (choice == 5) viewCustomers();
            else if (choice == 0) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Wrong choice");
            }

            System.out.println("\nPress Enter...");
            sc.nextLine();
        }
    }

    private static void showMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Clothing Item 👔");
        System.out.println("2. Add Accessory ⌚");
        System.out.println("3. View All Products 🗃️");
        System.out.println("4. Add Customer 🥷");
        System.out.println("5. View All Customers 🙎");
        System.out.println("0. Exit 👋");
        System.out.print("Choice: ");
    }

    private static void addClothing() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Category: ");
        String cat = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean(); sc.nextLine();

        products.add(new ClothingItem(name, price, cat, avail));
        System.out.println("Added!");
    }

    private static void addAccessory() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble(); sc.nextLine();
        System.out.print("Material: ");
        String mat = sc.nextLine();

        products.add(new Accessory(name, price, mat));
        System.out.println("Added!");
    }

    private static void viewProducts() {
        if (products.isEmpty()) {
            System.out.println("No products.");
            return;
        }

        System.out.println("\nAll Products:");
        for (Product p : products) {
            System.out.println(p.getName() + " — " + p.getPrice() + " KZT");
            System.out.println("  " + p.getInfo());
            System.out.println("  Action: " + p.work());

            if (p instanceof ClothingItem) {
                System.out.println("  → This is clothing");
            } else if (p instanceof Accessory) {
                System.out.println("  → This is accessory");3
            }
            System.out.println();
        }
    }

    private static void addCustomer() {
        System.out.print("ID: ");
        int id = sc.nextInt(); sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Bonus: ");
        int bonus = sc.nextInt(); sc.nextLine();

        customers.add(new Customer(id, name, phone, bonus));
        System.out.println("Added!");
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }

        System.out.println("\nAll Customers:");
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i+1) + ". " + c.getName() + " (ID " + c.getId() + ")");
            System.out.println("   Phone: " + c.getPhone());
            System.out.println("   Bonus: " + c.getBonus() + (c.isVIP() ? " (VIP)" : ""));
        }
    }
}