package com.solak.TravelExpenseTracking.Authentication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * This class manages authentication for users in the Travel Expense Tracking application.
 * It provides methods for user registration, login, and guest mode.
 */
public class AuthenticationManager implements AuthProvider {
    private Map<String, String> userCredentials; // Map to store user credentials (username, password)
    private Scanner scanner; // Scanner object for user input

    /**
     * Constructs an AuthenticationManager object.
     * Initializes the userCredentials map and the scanner for user input.
     */
    public AuthenticationManager() {
        userCredentials = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Creates a text file to store user credentials.
     * @param username The username of the user
     * @param password The password of the user
     */
    private void createTextFile(String username, String password) {
        String directoryPath = "Users/" + username;
        String filePath = directoryPath + "/" + username + ".txt";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            if (directory.mkdirs()) {
                System.out.println("User directory created: " + directoryPath);
            } else {
                System.out.println("Failed to create user directory: " + directoryPath);
                return;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Username: " + username);
            writer.newLine();
            writer.write("Password: " + password);
            System.out.println("User file created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates user credentials for login.
     * @param username The username entered by the user
     * @param password The password entered by the user
     * @return True if login is successful, otherwise False
     */
    @Override
    public boolean login(String username, String password) {
        String filePath = "Users/" + username + "/" + username + ".txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2 && parts[0].trim().equals("Username") && parts[1].trim().equals(username)) {
                    line = reader.readLine();
                    if (line != null && line.trim().equals("Password: " + password)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("An error occurred while attempting to login: " + e.getMessage());
        }

        System.out.println("Authentication failed. Invalid username or password.");
        return false;
    }

    /**
     * Registers a new user.
     * @param username The username chosen by the user
     * @param password The password chosen by the user
     * @return True if registration is successful, otherwise False
     */
    @Override
    public boolean register(String username, String password) {
        if (!userCredentials.containsKey(username)) {
            userCredentials.put(username, password);
            createTextFile(username, password); // Create text file when user is registered
            System.out.println("Registration successful.");
            return true;
        }
        System.out.println("Username already exists. Please choose another username.");
        return false;
    }

    /**
     * Activates guest mode.
     */
    @Override
    public void guestMode() {
        System.out.println("Guest mode activated.");
    }

    /**
     * Starts the authentication process.
     * Displays options for registration, login, guest mode, and exit.
     */
    public void startAuthentication() {
        System.out.println("Welcome to Travel Expense Tracking App!");

        boolean isLoggedIn = false;
        while (!isLoggedIn) {
            System.out.println("1. Register\n2. Login\n3. Guest Mode\n4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    performRegistration();
                    break;
                case 2:
                    isLoggedIn = performLogin();
                    break;
                case 3:
                    guestMode();
                    isLoggedIn = true; // Log out when entering guest mode
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        // Continue with authenticated user...
    }

    /**
     * Performs user registration.
     */
    private void performRegistration() {
        System.out.println("\nRegistration:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        register(username, password);
    }

    /**
     * Performs user login.
     * @return True if login is successful, otherwise False
     */
    private boolean performLogin() {
        System.out.println("\nLogin:");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        boolean isLoggedIn = login(username, password);
        if (isLoggedIn) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
        return isLoggedIn;
    }
}
