import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ExpenseManager manager = new ExpenseManager();

        while (true) {
            System.out.println("\n=== SMART EXPENSE SPLITTER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. View All Expenses");
            System.out.println("3. Show Balances");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter payer name: ");
                    String payer = sc.nextLine();
                    System.out.print("Enter amount: ₹");
                    double amount = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter description: ");
                    String desc = sc.nextLine();

                    System.out.print("Enter participants (comma separated): ");
                    String[] parts = sc.nextLine().split(",");
                    List<String> participants = new ArrayList<>();
                    for (String p : parts) participants.add(p.trim());

                    manager.addExpense(payer, amount, desc, participants);
                }

                case 2 -> manager.viewExpenses();
                case 3 -> manager.showBalances();
                case 4 -> {
                    System.out.println("👋 Exiting Smart Expense Splitter...");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
