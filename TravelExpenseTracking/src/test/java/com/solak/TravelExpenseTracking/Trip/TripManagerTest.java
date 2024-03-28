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

public class TripManagerTest {

    private TripManager tripManager;
    private static final String TEST_USERNAME = "testuser";
    private static final String TEST_TRIP_ID = "testtrip";
    private static final String TEST_DESTINATION = "Test Destination";
    private static final String TEST_START_DATE = "01/01/2024";
    private static final String TEST_END_DATE = "05/01/2024";
    private static final List<String> TEST_ACCOMMODATIONS = new ArrayList<>();
    private static final List<String> TEST_TRANSPORTATION = new ArrayList<>();
    private static final List<String> TEST_ACTIVITIES = new ArrayList<>();
    
    @Before
    public void setUp() throws Exception {
        tripManager = new TripManager();
        createTestTripFile();
        TEST_ACCOMMODATIONS.add("Hotel");
        TEST_TRANSPORTATION.add("Flight");
        TEST_ACTIVITIES.add("Sightseeing");
    }

    @After
    public void tearDown() throws Exception {
        deleteTestTripFile();
    }
    
    // Test createTrip method
    @Test
    public void testCreateTrip() {
        Trip trip = new Trip(TEST_TRIP_ID, TEST_DESTINATION, parseDate(TEST_START_DATE), parseDate(TEST_END_DATE), TEST_ACCOMMODATIONS, TEST_TRANSPORTATION, TEST_ACTIVITIES);
        tripManager.createTrip(TEST_USERNAME, trip);
        Trip foundTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        assertNotNull(foundTrip);
        assertEquals(TEST_TRIP_ID, foundTrip.getTripId());
        assertEquals(TEST_DESTINATION, foundTrip.getDestination());
    }
    
    // Test editTrip method
    @Test
    public void testEditTrip() {
        Trip newTrip = new Trip(TEST_TRIP_ID, "New Destination", parseDate(TEST_START_DATE), parseDate(TEST_END_DATE), TEST_ACCOMMODATIONS, TEST_TRANSPORTATION, TEST_ACTIVITIES);
        tripManager.editTrip(TEST_USERNAME, newTrip);
        Trip editedTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        assertNotNull(editedTrip);
        assertEquals("New Destination", editedTrip.getDestination());
    }
    
    // Test deleteTrip method
    @Test
    public void testDeleteTrip() {
        tripManager.deleteTrip(TEST_USERNAME, TEST_TRIP_ID);
        Trip deletedTrip = tripManager.findTripById(TEST_USERNAME, TEST_TRIP_ID);
        assertNull(deletedTrip);
    }

    // Helper method to create a test trip file
    private void createTestTripFile() throws IOException {
        String filename = "Users/testuser/testuser-trip.txt";
        File file = new File(filename);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            file.createNewFile();
        }
    }
    
    // Helper method to delete the test trip file
    private void deleteTestTripFile() {
        String filename = "Users/testuser/testuser-trip.txt";
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
    
    // Helper method to parse date string
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

