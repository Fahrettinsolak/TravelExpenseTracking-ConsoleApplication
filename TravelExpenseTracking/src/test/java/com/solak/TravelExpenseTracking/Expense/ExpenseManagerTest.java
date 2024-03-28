package com.solak.TravelExpenseTracking.Expense;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

public class ExpenseManagerTest {
    private ExpenseManager expenseManager;
    private List<Expense> expenses;

    @Before
    public void setUp() {
        expenseManager = new ExpenseManager();
        expenses = new ArrayList<>();
    }

    @Test
    public void testLogExpense() {
        UUID expenseId = UUID.randomUUID();
        Expense expense = new Expense(expenseId, null, 0, "", "");

        expenseManager.logExpense(expense);

        assertTrue(expenses.contains(expense));
    }

    @Test
    public void testEditExpense() {
        UUID expenseId = UUID.randomUUID();
        Expense originalExpense = new Expense(expenseId, null, 0, "", "");
        expenses.add(originalExpense);

        Date date = new Date();
        double amount = 50.0;
        String category = "Travel";
        String paymentMethod = "Cash";
        Expense editedExpense = new Expense(expenseId, date, amount, category, paymentMethod);

        expenseManager.editExpense(editedExpense);

        assertTrue(expenses.contains(editedExpense));
    }

    @Test
    public void testDeleteExpense() {
        UUID expenseId = UUID.randomUUID();
        Expense expense = new Expense(expenseId, null, 0, "", "");
        expenses.add(expense);

        expenseManager.deleteExpense(expenseId);

        assertTrue(expenses.isEmpty());
    }
}
