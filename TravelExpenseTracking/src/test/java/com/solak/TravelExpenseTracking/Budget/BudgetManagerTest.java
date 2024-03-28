package com.solak.TravelExpenseTracking.Budget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Map;

import org.junit.Test;

/**
 * This class contains unit tests for the BudgetManager class.
 */
public class BudgetManagerTest {

    private BudgetManager budgetManager; // Instance of BudgetManager to be tested
    private Map<String, Budget> budgets; // Map to store budgets for testing

    /**
     * Test case to verify the setBudget method of BudgetManager.
     */
    @Test
    public void testSetBudget() {
        // Create a test budget
        Budget budget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        
        // Call the setBudget method
        budgetManager.setBudget(budget);
        
        // Assert that the budget was successfully added to the map
        assertTrue(budgets.containsKey("Test Category"));
        assertEquals(budget, budgets.get("Test Category"));
    }

    /**
     * Test case to verify the editBudget method of BudgetManager.
     */
    @Test
    public void testEditBudget() {
        // Add an initial budget
        Budget initialBudget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        budgets.put("Test Category", initialBudget);

        // Create an updated budget
        Budget updatedBudget = new Budget(200, "USD", "Updated Budget", "Updated Type", "Test Category");

        // Call the editBudget method
        budgetManager.editBudget(updatedBudget);

        // Assert that the budget was updated successfully
        assertEquals(updatedBudget, budgets.get("Test Category"));
    }

    /**
     * Test case to verify the deleteBudget method of BudgetManager.
     */
    @Test
    public void testDeleteBudget() {
        // Add a budget
        Budget budget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        budgets.put("Test Category", budget);

        // Call the deleteBudget method
        budgetManager.deleteBudget("Test Category");

        // Assert that the budget was deleted successfully
        assertTrue(budgets.isEmpty());
    }
}
