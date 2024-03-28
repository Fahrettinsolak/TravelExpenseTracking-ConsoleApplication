package com.solak.TravelExpenseTracking.Budget;

public class BudgetRange extends Budget {
    private double maxAmount;

    public BudgetRange(double amount, double maxAmount, String currency, String description, String type, String category) {
        super(amount, currency, description, type, category);
        this.maxAmount = maxAmount;
    }

    public double getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }
}
