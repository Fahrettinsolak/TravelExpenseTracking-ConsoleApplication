package com.solak.TravelExpenseTracking.Budget;

/**
 * This class represents a budget object that contains information about a specific budget allocation.
 */
public class Budget {
    private double amount;      // The amount of the budget
    private String currency;    // The currency of the budget
    private String description; // A description of the budget
    private String type;        // The type of the budget (e.g., income, expense)
    private String category;    // The category of the budget (e.g., accommodation, transportation)
    // Other budget information can be added here

    /**
     * Constructs a budget object with the provided parameters.
     *
     * @param amount      The amount of the budget.
     * @param currency    The currency of the budget.
     * @param description A description of the budget.
     * @param type        The type of the budget (e.g., income, expense).
     * @param category    The category of the budget (e.g., accommodation, transportation).
     */
    public Budget(double amount, String currency, String description, String type, String category) {
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.type = type;
        this.category = category;
    }

    /**
     * Retrieves the category of the budget.
     *
     * @return The category of the budget.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Sets the category of the budget.
     *
     * @param category The category to be set.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Retrieves the amount of the budget.
     *
     * @return The amount of the budget.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Sets the amount of the budget.
     *
     * @param amount The amount to be set.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Retrieves the currency of the budget.
     *
     * @return The currency of the budget.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency of the budget.
     *
     * @param currency The currency to be set.
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Retrieves the description of the budget.
     *
     * @return The description of the budget.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description of the budget.
     *
     * @param description The description to be set.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Retrieves the type of the budget.
     *
     * @return The type of the budget.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the budget.
     *
     * @param type The type to be set.
     */
    public void setType(String type) {
        this.type = type;
    }
}
