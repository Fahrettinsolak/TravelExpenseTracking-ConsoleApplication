package com.solak.TravelExpenseTracking.Expense;

import java.util.Date;
import java.util.UUID;

/**
 * Expense class represents an expense made during travel.
 */
public class Expense {
    private UUID expenseId; // Unique identifier for the expense
    private Date date; // Date when the expense was made
    private double amount; // Amount spent
    private String category; // Category of the expense (e.g., accommodation, food, transportation)
    private String paymentMethod; // Payment method used for the expense

    /**
     * Constructor for Expense class.
     * @param expenseId Unique identifier for the expense.
     * @param date Date when the expense was made.
     * @param amount Amount spent for the expense.
     * @param category Category of the expense.
     * @param paymentMethod Payment method used for the expense.
     */
    public Expense(UUID expenseId, Date date, double amount, String category, String paymentMethod) {
        this.expenseId = expenseId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    // Getter and setter methods

    /**
     * Getter for expenseId.
     * @return The unique identifier of the expense.
     */
    public UUID getExpenseId() {
        return expenseId;
    }

    /**
     * Setter for expenseId.
     * @param expenseId The unique identifier to set for the expense.
     */
    public void setExpenseId(UUID expenseId) {
        this.expenseId = expenseId;
    }

    /**
     * Getter for date.
     * @return The date when the expense was made.
     */
    public Date getDate() {
        return date;
    }

    /**
     * Setter for date.
     * @param date The date to set for the expense.
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Getter for amount.
     * @return The amount spent for the expense.
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Setter for amount.
     * @param amount The amount to set for the expense.
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * Getter for category.
     * @return The category of the expense.
     */
    public String getCategory() {
        return category;
    }

    /**
     * Setter for category.
     * @param category The category to set for the expense.
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Getter for paymentMethod.
     * @return The payment method used for the expense.
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * Setter for paymentMethod.
     * @param paymentMethod The payment method to set for the expense.
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
