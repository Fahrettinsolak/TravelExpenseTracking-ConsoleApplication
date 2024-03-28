package com.solak.TravelExpenseTracking.Authentication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit tests for the AuthenticationManager class.
 */
public class AuthenticationManagerTest {

    private AuthenticationManager authenticationManager;

    /**
     * Sets up the test environment before each test method is executed.
     */
    @Before
    public void setUp() {
        authenticationManager = new AuthenticationManager();
    }

    /**
     * Tears down the test environment after each test method is executed.
     */
    @After
    public void tearDown() {
        authenticationManager = null;
    }

    /**
     * Test for the register method of AuthenticationManager.
     * Tests registering a new user with valid credentials and ensuring that registering the same username again fails.
     */
    @Test
    public void testRegister() {
        assertTrue(authenticationManager.register("testUser", "testPassword"));
        assertFalse(authenticationManager.register("testUser", "testPassword")); // Username already exists
    }

    /**
     * Test for the login method of AuthenticationManager.
     * Tests logging in with correct and incorrect credentials.
     */
    @Test
    public void testLogin() {
        String username = "testUser";
        String password = "testPassword";

        // Register a user
        authenticationManager.register(username, password);

        // Try to login with correct credentials
        assertTrue(authenticationManager.login(username, password));

        // Try to login with incorrect password
        assertFalse(authenticationManager.login(username, "wrongPassword"));

        // Try to login with incorrect username
        assertFalse(authenticationManager.login("wrongUsername", password));
    }

    /**
     * Test for the guestMode method of AuthenticationManager.
     * Tests that the guest mode always returns true.
     */
    @Test
    public void testGuestMode() {
        // Guest mode should always return true
        authenticationManager.guestMode();
    }
}
