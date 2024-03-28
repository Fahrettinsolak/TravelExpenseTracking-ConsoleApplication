/**
 * @file ConsoleUI.java
 * @brief Contains the implementation of the ConsoleUI class which handles the user interface in a console-based application for travel expense tracking.
 */

package com.solak.TravelExpenseTracking.Main;

//Import necessary packages
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import com.solak.TravelExpenseTracking.Authentication.AuthenticationManager;
import com.solak.TravelExpenseTracking.Authentication.User;
import com.solak.TravelExpenseTracking.Budget.Budget;
import com.solak.TravelExpenseTracking.Budget.BudgetManager;
import com.solak.TravelExpenseTracking.Budget.BudgetRange;
import com.solak.TravelExpenseTracking.Expense.Expense;
import com.solak.TravelExpenseTracking.Expense.ExpenseManager;
import com.solak.TravelExpenseTracking.Report.ReportManager;
import com.solak.TravelExpenseTracking.Trip.Trip;
import com.solak.TravelExpenseTracking.Trip.TripManager;

/**
 * @brief Represents the console-based user interface for the travel expense tracking application.
 */

public class ConsoleUI {
    private Scanner scanner;
    private AuthenticationManager authenticationManager;
    private TripManager tripManager;
    private ExpenseManager expenseManager;
    private BudgetManager budgetManager;
    private ReportManager reportManager;
    private User user;

    /**
     * @brief Constructor for ConsoleUI class.
     * @param user The user object.
     */
    
    public ConsoleUI(User user) {
        this.user = user;
        this.budgetManager = new BudgetManager(user);
        this.scanner = new Scanner(System.in);
        this.authenticationManager = new AuthenticationManager();
        this.tripManager = new TripManager();
        this.expenseManager = new ExpenseManager();
        this.reportManager = new ReportManager();
    }

    /**
     * @brief Starts the console application.
     */
    
    public void start() {
        String username = null;
        while (true) {
            System.out.println("Welcome to Travel Expense Tracking App!");
            System.out.println("1. Login\n2. Register\n3. Guest Mode\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    username = authenticateUser();
                    if (username != null) {
                        showOptionsMenu(username);
                    }
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    authenticationManager.guestMode();
                    showOptionsMenu(username);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }

    /**
     * @brief Authenticates a user.
     * @return The username if authentication is successful, null otherwise.
     */
    
    String authenticateUser() {
        System.out.println("Enter username:");
        String username = scanner.next();
        System.out.println("Enter password:");
        String password = scanner.next();
        boolean authenticated = authenticationManager.login(username, password);
        if (authenticated) {
            System.out.println("Authentication successful!");
            return username;
        } else {
            System.out.println("Authentication failed. Would you like to register? (Y/N)");
            String choice = scanner.next();
            if (choice.equalsIgnoreCase("Y")) {
                registerUser();
            }
            return null;
        }
    }
    
    /**
     * @brief Registers a new user.
     */
    
    private void registerUser() {
        System.out.println("Enter new username:");
        String username = scanner.next();
        System.out.println("Enter new password:");
        String password = scanner.next();
        boolean registered = authenticationManager.register(username, password);
        if (registered) {
            System.out.println("Registration successful! You can now login.");
        } else {
            System.out.println("Registration failed. Username already exists.");
        }
    }
    
    /**
     * @brief Displays the options menu based on user's role.
     * @param username The username of the logged-in user.
     */

    private void showOptionsMenu(String username) {
        while (true) {
            System.out.println("Options Menu:");
            System.out.println("1. Plan Trip");
            System.out.println("2. Record Expense");
            System.out.println("3. Manage Budget");
            System.out.println("4. Generate Report");
            System.out.println("5. View Reports");
            System.out.println("6. Logout and Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    planTrip(username);
                    break;
                case 2:
                    recordExpense();
                    break;
                case 3:
                    manageBudget(user);
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    viewReports();
                    break;
                case 6:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
    /**
     * @brief Plans a trip.
     * @param username The username of the logged-in user.
     */

    private void planTrip(String username) {
        System.out.println("Plan Trip Menu:");
        System.out.println("1. Create Trip");
        System.out.println("2. View Trips");
        System.out.println("3. Edit Trip");
        System.out.println("4. Delete Trip");
        System.out.println("5. Go Back");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                createTrip(username);
                break;
            case 2:
                viewTrips(username);
                break;
            case 3:
                editTrip(username);
                break;
            case 4:
                deleteTrip(username);
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

    /**
     * @brief Views trips for a user.
     * @param username The username of the logged-in user.
     */
    
    private void viewTrips(String username) {
        List<Trip> userTrips = tripManager.viewTrips(username);
        if (userTrips.isEmpty()) {
            System.out.println("No trips available.");
        } else {
            System.out.println("Your trips:");
            for (Trip trip : userTrips) {
                System.out.println(trip);
            }
        }
    }
    
    /**
     * @brief Creates a new trip.
     * @param username The username of the logged-in user.
     */
    
    private void createTrip(String username) {
        System.out.println("Enter destination:");
        String destination = scanner.next();
        System.out.println("Enter start date (dd/MM/yyyy):");
        String startDateStr = scanner.next();
        System.out.println("Enter end date (dd/MM/yyyy):");
        String endDateStr = scanner.next();

        // Parse dates
        Date startDate = parseDate(startDateStr);
        Date endDate = parseDate(endDateStr);

        // Get accommodations, transportation, and activities
        System.out.println("Enter accommodations (comma-separated):");
        String accommodationsInput = scanner.next();
        List<String> accommodations = Arrays.asList(accommodationsInput.split(","));

        System.out.println("Enter transportation (comma-separated):");
        String transportationInput = scanner.next();
        List<String> transportation = Arrays.asList(transportationInput.split(","));

        System.out.println("Enter activities (comma-separated):");
        String activitiesInput = scanner.next();
        List<String> activities = Arrays.asList(activitiesInput.split(","));

        // Create new trip object
        String tripId = generateTripId();
        Trip trip = new Trip(tripId, destination, startDate, endDate, accommodations, transportation, activities);

        // Add trip to TripManager
        tripManager.createTrip(username, trip);
    }
    
    /**
     * @brief Edits an existing trip.
     * @param username The username of the logged-in user.
     */
    
    private void editTrip(String username) {
        System.out.println("Enter trip ID to edit:");
        String tripId = scanner.next();
        Trip trip = tripManager.findTripById(username, tripId);
        if (trip == null) {
            System.out.println("Trip not found.");
            return;
        }

        // Get updated trip details
        System.out.println("Enter new destination:");
        String newDestination = scanner.next();
        System.out.println("Enter new start date (dd/MM/yyyy):");
        String newStartDateStr = scanner.next();
        System.out.println("Enter new end date (dd/MM/yyyy):");
        String newEndDateStr = scanner.next();

        // Parse dates
        Date newStartDate = parseDate(newStartDateStr);
        Date newEndDate = parseDate(newEndDateStr);

        // Get accommodations, transportation, and activities
        System.out.println("Enter new accommodations (comma-separated):");
        String newAccommodationsInput = scanner.next();
        List<String> newAccommodations = Arrays.asList(newAccommodationsInput.split(","));

        System.out.println("Enter new transportation (comma-separated):");
        String newTransportationInput = scanner.next();
        List<String> newTransportation = Arrays.asList(newTransportationInput.split(","));

        System.out.println("Enter new activities (comma-separated):");
        String newActivitiesInput = scanner.next();
        List<String> newActivities = Arrays.asList(newActivitiesInput.split(","));

        // Update trip details
        trip.setDestination(newDestination);
        trip.setStartDate(newStartDate);
        trip.setEndDate(newEndDate);
        trip.setAccommodations(newAccommodations);
        trip.setTransportation(newTransportation);
        trip.setActivities(newActivities);

        // Update trip in TripManager
        tripManager.editTrip(username, trip);
    }
    
    /**
     * @brief Deletes an existing trip.
     * @param username The username of the logged-in user.
     */
    
    private void deleteTrip(String username) {
        System.out.println("Enter trip ID to delete:");
        String tripId = scanner.next();
        tripManager.deleteTrip(username, tripId);
    }
    
    /**
     * @brief Generates a unique trip ID.
     * @return A unique trip ID as a string.
     */
    
    private String generateTripId() {
        // Logic to generate a unique trip ID
        return UUID.randomUUID().toString();
    }
    
    /**
     * @brief Parses a date string into a Date object.
     * @param dateStr The date string to parse.
     * @return The parsed Date object.
     */
    
    public static Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @brief Displays the expense menu and handles user's choice.
     */

    private void recordExpenseMenu() {
        System.out.println("Expense Menu:");
        System.out.println("1. Record Expense");
        System.out.println("2. View Expenses");
        System.out.println("3. Edit Expense");
        System.out.println("4. Delete Expense");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                recordExpense();
                break;
            case 2:
                viewExpenses();
                break;
            case 3:
                editExpense();
                break;
            case 4:
                deleteExpense();
                break;
            case 5:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
    
    /**
     * @brief Records a new expense.
     */
    
    private void recordExpense() {
        System.out.println("Enter expense details:");

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = parseDate(scanner.next());

        System.out.print("Amount: ");
        double amount = scanner.nextDouble();

        System.out.print("Category: ");
        String category = scanner.next();

        System.out.print("Payment Method: ");
        String paymentMethod = scanner.next();

        // Generate a unique expense ID
        UUID expenseId = UUID.randomUUID();

        // Create the expense object
        Expense expense = new Expense(expenseId, date, amount, category, paymentMethod);

        // Log the expense
        expenseManager.logExpense(expense);
    }
    
    /**
     * @brief Views all recorded expenses.
     */
    
    private void viewExpenses() {
        System.out.println("Available expenses:");
        expenseManager.viewExpenses();
    }
    
    /**
     * @brief Edits an existing expense.
     */
    
    private void editExpense() {
        System.out.println("Enter the ID of the expense to edit:");
        UUID expenseId;
        try {
            expenseId = UUID.fromString(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid expense ID format. Please enter a valid UUID.");
            return;
        }

        System.out.println("Enter updated expense details:");

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = parseDate(scanner.next());
        if (date == null) {
            System.out.println("Invalid date format. Please enter date in format dd/MM/yyyy.");
            return;
        }

        System.out.print("Amount: ");
        double amount;
        while (true) {
            try {
                amount = Double.parseDouble(scanner.next());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid amount format. Please enter a valid number.");
            }
        }

        System.out.print("Category: ");
        String category = scanner.next();

        System.out.print("Payment Method: ");
        String paymentMethod = scanner.next();

        // Create the expense object
        Expense expense = new Expense(expenseId, date, amount, category, paymentMethod);

        // Edit the expense
        expenseManager.editExpense(expense);
    }
    
    /**
     * @brief Deletes an existing expense.
     */
    
    private void deleteExpense() {
        System.out.println("Enter the ID of the expense to delete:");
        UUID expenseId;
        try {
            expenseId = UUID.fromString(scanner.next());
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid expense ID format. Please enter a valid UUID.");
            return;
        }

        // Delete the expense
        expenseManager.deleteExpense(expenseId);
    }
    		
    
    
    //Manage Budget

    /**
     * @brief Displays the budget menu and handles user's choice.
     * @param user The user object.
     */
    
    private void manageBudget(User user) {
        while (true) {
            displayBudgetMenu();
            int choice = getUserChoice();
            switch (choice) {
                case 1:
                    createBudget(user);
                    break;
                case 2:
                    viewBudgets();
                    break;
                case 3:
                    editBudget();
                    break;
                case 4:
                    deleteBudget();
                    break;
                case 5:
                    createBudgetRange(user);
                    break;
                case 6:
                    createBudgetProposal(user);
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
    
    /**
     * @brief Displays the budget menu options.
     */
    
    private void displayBudgetMenu() {
        System.out.println("Budget Menu:");
        System.out.println("1. Set Budget");
        System.out.println("2. View Budgets");
        System.out.println("3. Edit Budget");
        System.out.println("4. Delete Budget");
        System.out.println("5. Create Budget Range");
        System.out.println("6. Create Budget Proposal");
        System.out.println("7. Go Back");

    }
    
    /**
     * @brief Creates a new budget for the user.
     * @param user The user object.
     */
    
    private void createBudget(User user) {
        System.out.println("Enter category:");
        String category = scanner.next();
        System.out.println("Enter amount:");
        double amount = scanner.nextDouble();
        Budget budget = new Budget(amount, category, category, category, category);
        String username = user.getUsername(); // Kullanıcı adını al
        budgetManager.setBudget(budget, username);
    }
    
    /**
     * @brief Views all budgets set by the user.
     */
    
    private void viewBudgets() {
        budgetManager.viewBudget();
    }
    
    /**
     * @brief Edits an existing budget category.
     */
    
    private void editBudget() {
        System.out.println("Enter category to edit:");
        String category = scanner.next();
        System.out.println("Enter new amount:");
        double newAmount = scanner.nextDouble();
        
        // Mevcut bütçeyi al
        Budget currentBudget = budgetManager.getBudget(category);
        if (currentBudget != null) {
            // Mevcut bütçeyi güncelle
            currentBudget.setAmount(newAmount);
            System.out.println("Budget updated for category: " + category);
        } else {
            System.out.println("Budget not found for category: " + category);
        }
    }
    
    /**
     * @brief Deletes an existing budget category.
     */
    
    private void deleteBudget() {
        System.out.println("Enter category to delete:");
        String category = scanner.next();
        budgetManager.deleteBudget(category);
    }
    
    /**
     * @brief Creates a budget range for a specific category.
     * @param user The user object.
     */
    
    private void createBudgetRange(User user) {
        System.out.println("Creating a Budget Range:");

        System.out.print("Enter minimum budget amount: ");
        double minAmount = scanner.nextDouble();

        System.out.print("Enter maximum budget amount: ");
        double maxAmount = scanner.nextDouble();

        System.out.print("Enter currency (e.g., USD, EUR): ");
        String currency = scanner.next();

        System.out.print("Enter description: ");
        String description = scanner.next();

        System.out.print("Enter type (e.g., Per Person, Total): ");
        String type = scanner.next();

        System.out.print("Enter category: ");
        String category = scanner.next();

        BudgetRange budgetRange = new BudgetRange(minAmount, maxAmount, currency, description, type, category);
        String username = user.getUsername(); // Kullanıcı adını al
        budgetManager.setBudget(budgetRange, username);
    }
    
    /**
     * @brief Creates a budget proposal based on trip type and destination.
     * @param user The user object.
     */
    
    private void createBudgetProposal(User user) {
        System.out.println("Creating a Budget Proposal:");

        System.out.print("Enter trip type (e.g., city, beach): ");
        String tripType = scanner.next();

        System.out.print("Enter destination (e.g., Europe, Asia): ");
        String destination = scanner.next();

        Budget budgetProposal = budgetManager.createBudgetProposal(tripType, destination);
        String username = user.getUsername(); // Kullanıcı adını al
        budgetManager.setBudget(budgetProposal, username);
    }
    
    
    
    
   // generateReport
    
    /**
     * @brief Displays the report generation menu and handles user's choice.
     */
    
    private int getUserChoice() {
        System.out.print("Enter your choice: ");
        return scanner.nextInt();
    }
    
    /**
     * @brief Generates a report for trip expenses.
     */
    
    private void generateReport() {
        System.out.println("Report Generation Menu:");
        System.out.println("1. Generate Trip Expenses Report");
        System.out.println("2. Generate Budget Summary Report");
        System.out.println("3. Go Back");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                generateTripExpensesReport();
                break;
            case 2:
                generateBudgetSummaryReport();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
    
    /**
     * @brief Generates a report for trip expenses.
     */
    
    private void generateTripExpensesReport() {
    	 // Add code here to generate a report for total expenses of a specific trip
    }
    
    /**
     * @brief Generates a summary report for the user's budget.
     */
    
    private void generateBudgetSummaryReport() {
    	 // Add code here to generate a summary report for the user's budget
    }
    
    /**
     * @brief Displays the report types menu and handles user's choice.
     */
    
    private void viewReports() {
        System.out.println("Report Types:");
        System.out.println("1. Trip Expenses Report");
        System.out.println("2. Budget Summary Report");
        System.out.println("3. Go Back");

        int choice = getUserChoice();
        switch (choice) {
            case 1:
                viewTripExpensesReport();
                break;
            case 2:
                viewBudgetSummaryReport();
                break;
            case 3:
                return;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
    
    /**
     * @brief Views the trip expenses report for a specific trip.
     */
    
    private void viewTripExpensesReport() {
        System.out.println("Enter trip ID:");
        String tripId = scanner.next();
        reportManager.showTripExpensesReport(tripId);
    }
    
    /**
     * @brief Views the budget summary report.
     */
    
    private void viewBudgetSummaryReport() {
        
    }
    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    /**
     * @brief Gets the user's choice from the console input.
     * @return The integer representing the user's choice.
     */
    
}
