import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<ClothingItem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        items.add(new ClothingItem("T-Shirt", 3000, "Casual", true));
        items.add(new ClothingItem("Jeans", 7000, "Pants", true));

        customers.add(new Customer(1, "Ainur", "+77001112233", 50));
        customers.add(new Customer(2, "Madina", "+77775554433", 150));

        while (true) {
            System.out.println("\n=== CLOTHING STORE ===");
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Add Customer");
            System.out.println("4. View All Customers");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            int ch = sc.nextInt();
            sc.nextLine();

            if (ch == 1) addItem();
            else if (ch == 2) viewItems();
            else if (ch == 3) addCustomer();
            else if (ch == 4) viewCustomers();
            else if (ch == 0) {
                System.out.println("Bye!");
                break;
            } else {
                System.out.println("Wrong choice!");
            }

            System.out.println("Press Enter...");
            sc.nextLine();
        }
    }

    private static void addItem() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.print("Category: ");
        String cat = sc.nextLine();
        System.out.print("Available (true/false): ");
        boolean avail = sc.nextBoolean();
        sc.nextLine();

        items.add(new ClothingItem(name, price, cat, avail));
        System.out.println("Added!");
    }

    private static void viewItems() {
        if (items.isEmpty()) {
            System.out.println("No items.");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            ClothingItem it = items.get(i);
            System.out.println((i+1) + ". " + it.getName() + " - " + it.getPrice() + " KZT");
            System.out.println("   Cat: " + it.getCategory() + " | Avail: " + (it.isAvailable() ? "Yes" : "No"));
        }
    }

    private static void addCustomer() {
        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Bonus: ");
        int bonus = sc.nextInt();
        sc.nextLine();

        customers.add(new Customer(id, name, phone, bonus));
        System.out.println("Added!");
    }

    private static void viewCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers.");
            return;
        }
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            System.out.println((i+1) + ". " + c.getName() + " (ID: " + c.getCustomerId() + ")");
            System.out.println("   Phone: " + c.getPhoneNumber() + " | Bonus: " + c.getBonus() + (c.isVIP() ? " (VIP)" : ""));
        }
    }
}