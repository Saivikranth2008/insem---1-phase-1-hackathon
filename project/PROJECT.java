import java.util.Scanner;

public class PROJECT {
    
    // Simple arrays to store data
    static String[] names = {"Tomato", "Onion", "Potato", "Beans", "Carrot"};
    static int[] prices = {30, 40, 60, 75, 50};
    static int[] stock = {0, 0, 0, 0, 0};

    // Money trackers
    static int totalSpent = 0;
    static int totalEarnings = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Farmers' Market Tracker ---");
            System.out.println("1. Buy stock");
            System.out.println("2. Sell stock");
            System.out.println("3. View summary");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            if (choice == 1) {
                buyStock(scanner);
            } else if (choice == 2) {
                sellStock(scanner);
            } else if (choice == 3) {
                viewSummary();
            } else if (choice == 4) {
                System.out.println("Goodbye!");
            } else {
                System.out.println("Invalid option!");
            }

        } while (choice != 4);

        scanner.close();
    }

    // Method to show items and buy stock
    public static void buyStock(Scanner scanner) {
        System.out.println("\n--- Buy Stock ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " (" + prices[i] + " rupees/kg)");
        }

        System.out.print("Select item number: ");
        int itemNo = scanner.nextInt();
        int index = itemNo - 1; // Convert to 0-based index

        if (index >= 0 && index < names.length) {
            System.out.print("Enter quantity [KG]: ");
            int qty = scanner.nextInt();

            int cost = prices[index] * qty;
            stock[index] += qty;
            totalSpent += cost;

            System.out.println("Bought " + qty + "kg of " + names[index] + ". Cost: " + cost + " rupees.");
        } else {
            System.out.println("Invalid item number!");
        }
    }

    // Method to show items and sell stock
    public static void sellStock(Scanner scanner) {
        System.out.println("\n--- Sell Stock ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println((i + 1) + ". " + names[i] + " (Stock: " + stock[i] + "kg)");
        }

        System.out.print("Select item number: ");
        int itemNo = scanner.nextInt();
        int index = itemNo - 1;

        if (index >= 0 && index < names.length) {
            System.out.print("Enter quantity [KG]: ");
            int qty = scanner.nextInt();

            if (qty <= stock[index]) {
                int earned = prices[index] * qty;
                stock[index] -= qty;
                totalEarnings += earned;

                System.out.println("Sold " + qty + "kg of " + names[index] + ". Earned: " + earned + " rupees.");
            } else {
                System.out.println("Not enough stock available!");
            }
        } else {
            System.out.println("Invalid item number!");
        }
    }

    // Method to print the final summary
    public static void viewSummary() {
        System.out.println("\n--- Inventory & Money Summary ---");
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " stock: " + stock[i] + " kg");
        }
        System.out.println("Total Money Spent: " + totalSpent + " rupees");
        System.out.println("Total Earnings: " + totalEarnings + " rupees");
    }
}
