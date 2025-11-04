public class Expense {
    private String payer;
    private double amount;
    private String description;

    public Expense(String payer, double amount, String description) {
        this.payer = payer;
        this.amount = amount;
        this.description = description;
    }

    public String getPayer() {
        return payer;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return payer + " paid ₹" + amount + " for " + description;
    }
}
