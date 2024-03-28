package com.solak.TravelExpenseTracking.Authentication;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthenticationManagerTest {

    private AuthenticationManager authenticationManager;

    @Before
    public void setUp() {
        authenticationManager = new AuthenticationManager();
    }

    @After
    public void tearDown() {
        authenticationManager = null;
    }

    @Test
    public void testRegister() {
        assertTrue(authenticationManager.register("testUser", "testPassword"));
        assertFalse(authenticationManager.register("testUser", "testPassword")); // Username already exists
    }

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

    @Test
    public void testGuestMode() {
        // Guest mode should always return true
        authenticationManager.guestMode();
    }
}