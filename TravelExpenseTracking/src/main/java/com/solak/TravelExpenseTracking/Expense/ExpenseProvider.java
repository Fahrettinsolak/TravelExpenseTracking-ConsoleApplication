package com.solak.TravelExpenseTracking.Expense;

import java.util.UUID;

/**
 * This interface defines methods for managing expenses in a travel expense tracking system.
 */
public interface ExpenseProvider {

    /**
     * Logs a new expense in the system.
     * 
     * @param expense The expense object to be logged.
     */
    void logExpense(Expense expense);

    /**
     * Displays all the expenses stored in the system.
     */
    void viewExpenses();

    /**
     * Edits an existing expense in the system.
     * 
     * @param expense The expense object containing the updated information.
     */
    void editExpense(Expense expense);

    /**
     * Deletes an expense from the system based on its unique identifier.
     * 
     * @param expenseId The unique identifier (UUID) of the expense to be deleted.
     */
    void deleteExpense(UUID expenseId);
}