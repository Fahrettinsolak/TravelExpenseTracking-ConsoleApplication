package com.solak.TravelExpenseTracking.Main;

import com.solak.TravelExpenseTracking.Authentication.User;

/**
 * This class represents the entry point of the Travel Expense Tracking application.
 */
public class Main {
    /**
     * The main method instantiates a User object with provided credentials,
     * creates a ConsoleUI instance, and starts the application.
     * 
     * @param args Command line arguments (not used in this application).
     */
    public static void main(String[] args) {
        // Create a User object with a username and password
        User user = new User("username", "password");
        
        // Create a ConsoleUI instance with the created user object
        ConsoleUI consoleUI = new ConsoleUI(user);
        
        // Start the application by invoking the start method of ConsoleUI
        consoleUI.start();
    }
}
