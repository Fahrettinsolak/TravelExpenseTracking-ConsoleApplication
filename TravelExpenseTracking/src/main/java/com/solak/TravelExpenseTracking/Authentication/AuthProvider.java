package com.solak.TravelExpenseTracking.Authentication;

/**
 * The AuthProvider interface defines methods for authentication and user registration.
 */
public interface AuthProvider {
    
    /**
     * Logs in a user with the provided username and password.
     * 
     * @param username The username of the user.
     * @param password The password of the user.
     * @return true if the login is successful, false otherwise.
     */
    boolean login(String username, String password);
    
    /**
     * Registers a new user with the provided username and password.
     * 
     * @param username The username for the new user.
     * @param password The password for the new user.
     * @return true if the registration is successful, false otherwise.
     */
    boolean register(String username, String password);
    
    /**
     * Sets the system to guest mode, allowing limited access without authentication.
     */
    void guestMode();
}
