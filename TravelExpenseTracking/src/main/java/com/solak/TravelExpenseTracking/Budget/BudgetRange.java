package com.solak.TravelExpenseTracking.Budget;

/**
 * This class represents a budget range, which is a type of budget with a maximum amount limit.
 * It extends the abstract class Budget.
 */
public class BudgetRange extends Budget {
    /** The maximum amount allowed for this budget range. */
    private double maxAmount;

    /**
     * Constructs a BudgetRange object with specified parameters.
     *
     * @param amount      The initial amount allocated for this budget range.
     * @param maxAmount   The maximum amount allowed for this budget range.
     * @param currency    The currency of the budget.
     * @param description A brief description of the budget.
     * @param type        The type of budget (e.g., "Income" or "Expense").
     * @param category    The category of the budget (e.g., "Travel" or "Food").
     */
    public BudgetRange(double amount, double maxAmount, String currency, String description, String type, String category) {
        super(amount, currency, description, type, category);
        this.maxAmount = maxAmount;
    }

    /**
     * Retrieves the maximum amount allowed for this budget range.
     *
     * @return The maximum amount allowed.
     */
    public double getMaxAmount() {
        return maxAmount;
    }

    /**
     * Sets the maximum amount allowed for this budget range.
     *
     * @param maxAmount The maximum amount allowed.
     */
    public void setMaxAmount(double maxAmount) {
        this.maxAmount = maxAmount;
    }
}
