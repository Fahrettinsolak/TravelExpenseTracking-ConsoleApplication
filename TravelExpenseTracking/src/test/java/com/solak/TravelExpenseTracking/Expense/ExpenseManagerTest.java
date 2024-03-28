package com.solak.TravelExpenseTracking.Expense;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * This class contains unit tests for the ExpenseManager class.
 */
public class ExpenseManagerTest {
    private ExpenseManager expenseManager; // Instance of ExpenseManager to be tested
    private List<Expense> expenses; // List to hold expenses

    /**
     * Setup method to initialize objects before each test case.
     */
    @Before
    public void setUp() {
        expenseManager = new ExpenseManager(); // Instantiate ExpenseManager
        expenses = new ArrayList<>(); // Instantiate List of expenses
    }

    /**
     * Test case to verify logging of an expense.
     */
    @Test
    public void testLogExpense() {
        UUID expenseId = UUID.randomUUID(); // Generate a random UUID for expense ID
        Expense expense = new Expense(expenseId, null, 0, "", ""); // Create a new expense object

        expenseManager.logExpense(expense); // Log the expense

        assertTrue(expenses.contains(expense)); // Assert that the expense is added to the list
    }

    /**
     * Test case to verify editing of an expense.
     */
    @Test
    public void testEditExpense() {
        UUID expenseId = UUID.randomUUID(); // Generate a random UUID for expense ID
        Expense originalExpense = new Expense(expenseId, null, 0, "", ""); // Create an original expense
        expenses.add(originalExpense); // Add the original expense to the list

        Date date = new Date(); // Current date
        double amount = 50.0; // Updated amount
        String category = "Travel"; // Updated category
        String paymentMethod = "Cash"; // Updated payment method
        Expense editedExpense = new Expense(expenseId, date, amount, category, paymentMethod); // Create edited expense

        expenseManager.editExpense(editedExpense); // Edit the expense

        assertTrue(expenses.contains(editedExpense)); // Assert that the edited expense is in the list
    }

    /**
     * Test case to verify deletion of an expense.
     */
    @Test
    public void testDeleteExpense() {
        UUID expenseId = UUID.randomUUID(); // Generate a random UUID for expense ID
        Expense expense = new Expense(expenseId, null, 0, "", ""); // Create a new expense
        expenses.add(expense); // Add the expense to the list

        expenseManager.deleteExpense(expenseId); // Delete the expense

        assertTrue(expenses.isEmpty()); // Assert that the list of expenses is empty
    }
}
