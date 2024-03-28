package com.solak.TravelExpenseTracking.Authentication;

/**
 * This class represents a user in the authentication system.
 */
public class User {
    // Private fields to store username and password
    private String username;
    private String password;

    /**
     * Constructor to initialize a User object with username and password.
     * @param username The username of the user.
     * @param password The password of the user.
     */
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Getter method to retrieve the username of the user.
     * @return The username of the user.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter method to set the username of the user.
     * @param username The new username to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Getter method to retrieve the password of the user.
     * @return The password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method to set the password of the user.
     * @param password The new password to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
