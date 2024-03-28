package com.solak.TravelExpenseTracking.Expense;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ExpenseManager implements ExpenseProvider {
    private List<Expense> expenses;
    
    
    public ExpenseManager() {
        expenses = new ArrayList<>();
    }
    public List<Expense> getExpenses() {
        return expenses;
    }
    @Override
    public void logExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense logged.");
    }
    

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
