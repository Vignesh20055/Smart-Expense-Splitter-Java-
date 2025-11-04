import java.io.*;
import java.util.*;

public class ExpenseManager {
    private List<Expense> expenses = new ArrayList<>();
    private Map<String, Double> balances = new HashMap<>();
    private final String FILE_PATH = "expenses.txt";

    public void addExpense(String payer, double amount, String description, List<String> participants) {
        Expense expense = new Expense(payer, amount, description);
        expenses.add(expense);

        double splitAmount = amount / participants.size();

        for (String person : participants) {
            balances.putIfAbsent(person, 0.0);
            if (person.equals(payer)) {
                balances.put(person, balances.get(person) + (amount - splitAmount));
            } else {
                balances.put(person, balances.get(person) - splitAmount);
            }
        }

        System.out.println("✅ Expense added successfully!");
        saveToFile();
    }

    public void viewExpenses() {
        System.out.println("\n🧾 Expense List:");
        for (Expense e : expenses) System.out.println(e);
    }

    public void showBalances() {
        System.out.println("\n💰 Balances:");
        for (Map.Entry<String, Double> entry : balances.entrySet()) {
            System.out.printf("%s: ₹%.2f\n", entry.getKey(), entry.getValue());
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (Expense e : expenses) writer.println(e);
            writer.println("\nBalances:");
            for (Map.Entry<String, Double> entry : balances.entrySet()) {
                writer.println(entry.getKey() + ": ₹" + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}
