package com.solak.TravelExpenseTracking.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * The ExpenseManager class manages a list of expenses and provides methods
 * to log, view, edit, and delete expenses.
 */
public class ExpenseManager implements ExpenseProvider {
    private List<Expense> expenses;

    /**
     * Constructs an ExpenseManager object with an empty list of expenses.
     */
    public ExpenseManager() {
        expenses = new ArrayList<>();
    }

    /**
     * Retrieves the list of expenses.
     * 
     * @return The list of expenses.
     */
    public List<Expense> getExpenses() {
        return expenses;
    }

    /**
     * Logs an expense by adding it to the list of expenses.
     * 
     * @param expense The expense to be logged.
     */
    @Override
    public void logExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense logged.");
    }

    /**
     * Displays all available expenses.
     */
    @Override
    public void viewExpenses() {
        if (expenses.isEmpty()) {
            System.out.println("No expenses available.");
        } else {
            System.out.println("Available expenses:");
            for (Expense expense : expenses) {
                System.out.println("Date: " + expense.getDate() + ", Amount: " + expense.getAmount() +
                        ", Category: " + expense.getCategory() + ", Payment Method: " + expense.getPaymentMethod());
            }
        }
    }

    /**
     * Edits an existing expense with the provided details.
     * 
     * @param expense The updated expense information.
     */
    @Override
    public void editExpense(Expense expense) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseId().equals(expense.getExpenseId())) {
                expenses.set(i, expense);
                System.out.println("Expense edited.");
                return;
            }
        }
        System.out.println("Expense not found.");
    }

    /**
     * Deletes an expense with the specified expense ID.
     * 
     * @param expenseId The ID of the expense to be deleted.
     */
    @Override
    public void deleteExpense(UUID expenseId) {
        for (int i = 0; i < expenses.size(); i++) {
            if (expenses.get(i).getExpenseId().equals(expenseId)) {
                expenses.remove(i);
                System.out.println("Expense deleted.");
                return;
            }
        }
        System.out.println("Expense not found.");
    }
}
