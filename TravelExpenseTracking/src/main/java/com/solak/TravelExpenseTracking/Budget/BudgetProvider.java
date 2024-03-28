package com.solak.TravelExpenseTracking.Budget;

/**
 * Interface for providing budget-related functionalities.
 */
public interface BudgetProvider {
    
    /**
     * Sets the budget.
     * @param budget The budget to be set.
     */
    void setBudget(Budget budget);
    
    /**
     * Displays the current budget.
     */
    void viewBudget();
    
    /**
     * Edits the existing budget with new budget details.
     * @param newBudget The new budget details to be updated.
     */
    void editBudget(Budget newBudget);
    
    /**
     * Deletes the budget for a specific category.
     * @param category The category of the budget to be deleted.
     */
    void deleteBudget(String category);
    
    /**
     * Sets the budget for a specific user.
     * @param budget The budget to be set.
     * @param username The username for whom the budget is being set.
     */
    void setBudget(Budget budget, String username);
    
    /**
     * Creates a budget range.
     * @return The created budget range.
     */
    Budget createBudgetRange();
    
    /**
     * Creates a budget proposal based on trip type and destination.
     * @param tripType The type of trip (e.g., business, leisure).
     * @param destination The destination of the trip.
     * @return The created budget proposal.
     */
    Budget createBudgetProposal(String tripType, String destination);
}
