package com.solak.TravelExpenseTracking.Expense;

import java.util.UUID;

public interface ExpenseProvider {
	void logExpense(Expense expense);
    void viewExpenses();
    void editExpense(Expense expense);
    void deleteExpense(UUID expenseId);
}
