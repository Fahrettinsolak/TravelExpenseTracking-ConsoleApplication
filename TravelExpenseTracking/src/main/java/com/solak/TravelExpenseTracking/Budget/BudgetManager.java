package com.solak.TravelExpenseTracking.Budget;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.solak.TravelExpenseTracking.Authentication.User;

public class BudgetManager implements BudgetProvider {
	
    public Map<String, Budget> budgets;
    private User user;
    public BudgetManager(User user) {
        budgets = new HashMap<>();
        this.user = user;
    }
    
    public Budget getBudget(String category) {
        return budgets.get(category);
    }
    @Override
    public void setBudget(Budget budget) {
        budgets.put(budget.getCategory(), budget);
        System.out.println("Budget set for category: " + budget.getCategory());
    }
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
        scanner.nextLine(); // Yeni satır karakterini tüket
        String description = scanner.nextLine();

        String defaultType = "Total"; 
        String defaultCategory = "General";

        // Kullanıcının girdiği bilgilerle bütçe aralığı oluşturma
        String budgetRangeDescription = "Budget range from " + minBudgetAmount + " to " + maxBudgetAmount + " " + currency;

        // BudgetRange sınıfını kullanarak bütçe aralığı oluşturma
        return new BudgetRange(minBudgetAmount, maxBudgetAmount, currency, description, defaultType, defaultCategory);
    }

    @Override
    public Budget createBudgetProposal(String tripType, String destination) {
        // Belirli bir seyahat türü ve hedefine göre bütçe önerisi oluşturmak için BudgetProposalGenerator sınıfını kullanma
        BudgetProposalGenerator proposalGenerator = new BudgetProposalGenerator();
        return proposalGenerator.createBudgetProposal(tripType, destination);
    }
    @Override
    public void setBudget(Budget budget, String username) {
        budgets.put(budget.getCategory(), budget);
        System.out.println("Budget set for category: " + budget.getCategory());
        
        // Budget'i dosyaya kaydet
        saveBudgetToFile(budget, username);
    }
    private void saveBudgetToFile(Budget budget, String username) {
        try {
            // Dosya yolunu oluştur
            String filePath = "C:/Users/" + username + "/" + username + "-budget.txt";
            
            // Dosyayı oluştur
            File file = new File(filePath);
            file.getParentFile().mkdirs(); // Gerekirse dizini oluştur
            
            // Dosyaya yaz
            FileWriter writer = new FileWriter(file);
            writer.write(budget.toString());
            writer.close();
        } catch (IOException e) {
            System.out.println("Error occurred while saving budget to file.");
            e.printStackTrace();
        }
    }
    
    
    private String getUsernameFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        return scanner.nextLine();
    }


    
}