package com.solak.TravelExpenseTracking.Budget;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import java.util.Map;

import org.junit.Test;

public class BudgetManagerTest {

    private BudgetManager budgetManager;
    private Map<String, Budget> budgets;


    @Test
    public void testSetBudget() {
        Budget budget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        budgetManager.setBudget(budget);
        assertTrue(budgets.containsKey("Test Category"));
        assertEquals(budget, budgets.get("Test Category"));
    }

    @Test
    public void testEditBudget() {
        // Öncelikle bir bütçe ekleyelim
        Budget initialBudget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        budgets.put("Test Category", initialBudget);

        // Güncellenmiş bir bütçe oluşturalım
        Budget updatedBudget = new Budget(200, "USD", "Updated Budget", "Updated Type", "Test Category");

        // Metodu çağıralım
        budgetManager.editBudget(updatedBudget);

        // Bütçenin güncellenip güncellenmediğini kontrol edelim
        assertEquals(updatedBudget, budgets.get("Test Category"));
    }

    @Test
    public void testDeleteBudget() {
        // Öncelikle bir bütçe ekleyelim
        Budget budget = new Budget(100, "USD", "Test Budget", "Test Type", "Test Category");
        budgets.put("Test Category", budget);

        // Bütçeyi silelim
        budgetManager.deleteBudget("Test Category");

        // Bütçenin silinip silinmediğini kontrol edelim
        assertTrue(budgets.isEmpty());
    }
}
