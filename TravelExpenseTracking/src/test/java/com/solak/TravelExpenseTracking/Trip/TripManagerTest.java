/**
 * @file TripManagerTest.java
 * @brief This file contains unit tests for the TripManager class.
 */

package com.solak.TravelExpenseTracking.Trip;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @class TripManagerTest
 * @brief This class contains unit tests for the TripManager class.
 */
public class TripManagerTest {

    private TripManager tripManager; // TripManager instance for testing
    private static final String TEST_USERNAME = "testuser"; // Test username
    private static final String TEST_TRIP_ID = "testtrip"; // Test trip ID
    private static final String TEST_DESTINATION = "Test Destination"; // Test trip destination
    private static final String TEST_START_DATE = "01/01/2024"; // Test start date
    private static final String TEST_END_DATE = "05/01/2024"; // Test end date
    private static final List<String> TEST_ACCOMMODATIONS = new ArrayList<>(); // Test accommodations list
    private static final List<String> TEST_TRANSPORTATION = new ArrayList<>(); // Test transportation list
    private static final List<String> TEST_ACTIVITIES = new ArrayList<>(); // Test activities list
    
    /**
     * @brief Setup method executed before each test.
     * @throws Exception If an error occurs during setup.
     */
    @Before
    public void setUp() throws Exception {
        tripManager = new TripManager(); // Initialize TripManager
        createTestTripFile(); // Create test trip file
        TEST_ACCOMMODATIONS.add("Hotel"); // Add test accommodation
        TEST_TRANSPORTATION.add("Flight"); // Add test transportation
        TEST_ACTIVITIES.add("Sightseeing"); // Add test activity
    }

    /**
     * @brief Tear down method executed after each test.
     * @throws Exception If an error occurs during teardown.
     */
    @After
    public void tearDown() throws Exception {
        deleteTestTripFile(); // Delete test trip file
    }
    
    /**
     * @brief Test case for creating a trip.
     */
    @Test
    public void testCreateTrip() {
        // Create a test trip
        Trip trip = new Trip(TEST_TRIP_ID, TEST_DESTINATION, parseDate(TEST_START_DATE), parseDate(TEST_END_DATE), TEST_ACCOMMODATIONS, TEST_TRANSPORTATION, TEST_ACTIVITIES);
        // Add the trip
        tripManager.createTrip(TEST_USERNAME, trip);
        // Find the trip
        Trip foundTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        // Assert that the trip is found
        assertNotNull(foundTrip);
        // Assert that the trip ID matches
        assertEquals(TEST_TRIP_ID, foundTrip.getTripId());
        // Assert that the destination matches
        assertEquals(TEST_DESTINATION, foundTrip.getDestination());
    }
    
    /**
     * @brief Test case for editing a trip.
     */
    @Test
    public void testEditTrip() {
        // Create a new trip with modified destination
        Trip newTrip = new Trip(TEST_TRIP_ID, "New Destination", parseDate(TEST_START_DATE), parseDate(TEST_END_DATE), TEST_ACCOMMODATIONS, TEST_TRANSPORTATION, TEST_ACTIVITIES);
        // Edit the trip
        tripManager.editTrip(TEST_USERNAME, newTrip);
        // Find the edited trip
        Trip editedTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        // Assert that the trip is found
        assertNotNull(editedTrip);
        // Assert that the destination is updated
        assertEquals("New Destination", editedTrip.getDestination());
    }
    
    /**
     * @brief Test case for deleting a trip.
     */
    @Test
    public void testDeleteTrip() {
        // Delete the trip
        tripManager.deleteTrip(TEST_USERNAME, TEST_TRIP_ID);
        // Try to find the deleted trip
        Trip deletedTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        // Assert that the trip is not found
        assertNull(deletedTrip);
    }

    /**
     * @brief Helper method to create a test trip file.
     * @throws IOException If an I/O error occurs.
     */
    private void createTestTripFile() throws IOException {
        // Define the file path
        String filename = "Users/testuser/testuser-trip.txt";
        // Create the file if it doesn't exist
        File file = new File(filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }
    
    /**
     * @brief Helper method to delete the test trip file.
     */
    private void deleteTestTripFile() {
        // Define the file path
        String filename = "Users/testuser/testuser-trip.txt";
        // Delete the file if it exists
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
    
    /**
     * @brief Helper method to parse date string.
     * @param dateStr The date string to parse.
     * @return The parsed Date object.
     */
    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.parse(dateStr);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
