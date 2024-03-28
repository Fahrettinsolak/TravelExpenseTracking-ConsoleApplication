package com.solak.TravelExpenseTracking.Budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.solak.TravelExpenseTracking.Authentication.User;

/**
 * Manages budgets including creation, modification, deletion, and persistence to file.
 */
public class BudgetManager implements BudgetProvider {
    
    /** Holds budgets mapped by category. */
    public Map<String, Budget> budgets;
    
    /** The user associated with this budget manager. */
    private User user;
    
    /**
     * Constructs a BudgetManager object.
     * @param user The user associated with this budget manager.
     */
    public BudgetManager(User user) {
        budgets = new HashMap<>();
        this.user = user;
    }
    
    /**
     * Gets the budget for the specified category.
     * @param category The category of the budget.
     * @return The budget associated with the category.
     */
    public Budget getBudget(String category) {
        return budgets.get(category);
    }
    
    @Override
    public void setBudget(Budget budget) {
        budgets.put(budget.getCategory(), budget);
        System.out.println("Budget set for category: " + budget.getCategory());
    }
    
    /**
     * Constructs a BudgetManager object without a user.
     */
    public BudgetManager() {
        budgets = new HashMap<>();
    }

    @Override
    public void viewBudget() {
        if (budgets.isEmpty()) {
            System.out.println("No budgets available.");
        } else {
            System.out.println("Available budgets:");
            for (Map.Entry<String, Budget> entry : budgets.entrySet()) {
                Budget budget = entry.getValue();
                System.out.println("Category: " + entry.getKey() + ", Amount: " + budget.getAmount());
            }
        }
    }

    @Override
    public void editBudget(Budget newBudget) {
        String category = newBudget.getCategory();
        if (budgets.containsKey(category)) {
            budgets.put(category, newBudget);
            System.out.println("Budget updated for category: " + category);
        } else {
            System.out.println("Budget not found for category: " + category);
        }
    }

    @Override
    public void deleteBudget(String category) {
        if (budgets.containsKey(category)) {
            budgets.remove(category);
            System.out.println("Budget deleted for category: " + category);
        } else {
            System.out.println("Budget not found for category: " + category);
        }
    }

    @Override
    public Budget createBudgetRange() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your minimum budget amount: ");
        double minBudgetAmount = scanner.nextDouble();

        System.out.print("Enter your maximum budget amount: ");
        double maxBudgetAmount = scanner.nextDouble();

        System.out.print("Enter your currency (e.g., USD, EUR): ");
        String currency = scanner.next();

        System.out.print("Enter a description for your budget: ");
        scanner.nextLine(); // Consume newline character
        String description = scanner.nextLine();

        String defaultType = "Total"; 
        String defaultCategory = "General";

        // Create a budget range using the user input
        String budgetRangeDescription = "Budget range from " + minBudgetAmount + " to " + maxBudgetAmount + " " + currency;
        
        // Use BudgetRange class to create the budget range
        return new BudgetRange(minBudgetAmount, maxBudgetAmount, currency, description, defaultType, defaultCategory);
    }

    @Override
    public Budget createBudgetProposal(String tripType, String destination) {
        // Use BudgetProposalGenerator class to create a budget proposal based on a specific trip type and destination
        BudgetProposalGenerator proposalGenerator = new BudgetProposalGenerator();
        return proposalGenerator.createBudgetProposal(tripType, destination);
    }
    
    @Override
    public void setBudget(Budget budget, String username) {
        budgets.put(budget.getCategory(), budget);
        System.out.println("Budget set for category: " + budget.getCategory());
        
        // Save the budget to a file
        saveBudgetToFile(budget, username);
    }
    
    /**
     * Saves a budget to a file.
     * @param budget The budget to be saved.
     * @param username The username associated with the budget.
     */
    private void saveBudgetToFile(Budget budget, String username) {
        try {
            // Construct the file path
            String filePath = "C:/Users/" + username + "/" + username + "-budget.txt";
            
            // Create the file
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Create directories if necessary
            
            // Write to the file
            FileWriter writer = new FileWriter(file);
            writer.write(budget.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving budget to file.");
            e.printStackTrace();
        }
    }
    
    
    /**
     * Gets the username from user input.
     * @return The username entered by the user.
     */
    private String getUsernameFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }
}
