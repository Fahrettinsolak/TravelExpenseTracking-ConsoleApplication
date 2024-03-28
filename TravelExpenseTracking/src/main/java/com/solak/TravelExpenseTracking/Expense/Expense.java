package com.solak.TravelExpenseTracking.Expense;

import java.util.Date;
import java.util.UUID;

public class Expense {
    private UUID expenseId;
    private Date date;
    private double amount;
    private String category; // Kategori eklendi
    private String paymentMethod;

    public Expense(UUID expenseId, Date date, double amount, String category, String paymentMethod) {
        this.expenseId = expenseId;
        this.date = date;
        this.amount = amount;
        this.category = category;
        this.paymentMethod = paymentMethod;
    }

    // Getter ve setter metotları
    public UUID getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(UUID expenseId) {
        this.expenseId = expenseId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
