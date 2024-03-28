package com.solak.TravelExpenseTracking.Budget;

public interface BudgetProvider {
    void setBudget(Budget budget);
    void viewBudget();
    void editBudget(Budget newBudget);
    void deleteBudget(String category);
    void setBudget(Budget budget, String username);
    Budget createBudgetRange();
    // Bütçe önerisi oluşturma yöntemi
    Budget createBudgetProposal(String tripType, String destination);
}
