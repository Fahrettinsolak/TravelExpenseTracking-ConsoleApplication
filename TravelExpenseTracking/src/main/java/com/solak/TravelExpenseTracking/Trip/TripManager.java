package com.solak.TravelExpenseTracking.Trip;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class TripManager implements TripProvider {

    private List<Trip> trips;
    private static final String TRIP_FOLDER = "Users/";

    public TripManager() {
        trips = new ArrayList<>();
    }
    public Trip findTripById(String username, String tripId) {
        List<Trip> userTrips = viewTrips(username);
        for (Trip trip : userTrips) {
            if (trip.getTripId().equals(tripId)) {
                return trip;
            }
        }
        return null; // Trip not found
    }
    

    @Override
    public void createTrip(String username, Trip trip) {
        trips.add(trip);
        saveTripToFile(username, trip);
        System.out.println("New trip created.");
    }

    @Override
    public List<Trip> viewTrips(String username) {
        List<Trip> userTrips = new ArrayList<>();
        String tripFilePath = TRIP_FOLDER + username + "/" + username + "-trip.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(tripFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Trip trip = parseTrip(parts);
                userTrips.add(trip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (userTrips.isEmpty()) {
            System.out.println("No trips available for user: " + username);
        } else {
            System.out.println("Available trips for user " + username + ":");
            for (Trip trip : userTrips) {
                System.out.println("Trip ID: " + trip.getTripId() + ", Destination: " + trip.getDestination() + ", Start Date: " + trip.getStartDate() + ", End Date: " + trip.getEndDate());
            }
        }

        return userTrips;
    }

    @Override
    public void editTrip(String username, Trip trip) {
        List<Trip> userTrips = new ArrayList<>();
        String tripFilePath = TRIP_FOLDER + username + "/" + username + "-trip.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(tripFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Trip currentTrip = parseTrip(parts);
                if (currentTrip.getTripId().equals(trip.getTripId())) {
                    currentTrip = trip;
                }
                userTrips.add(currentTrip);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated trips to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tripFilePath))) {
            for (Trip t : userTrips) {
                writer.write(t.toString());
                writer.newLine();
            }
            System.out.println("Trip edited.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteTrip(String username, String tripId) {
        List<Trip> userTrips = new ArrayList<>();
        String tripFilePath = TRIP_FOLDER + username + "/" + username + "-trip.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(tripFilePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Trip currentTrip = parseTrip(parts);
                if (!currentTrip.getTripId().equals(tripId)) {
                    userTrips.add(currentTrip);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Write updated trips to file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tripFilePath))) {
            for (Trip t : userTrips) {
                writer.write(t.toString());
                writer.newLine();
            }
            System.out.println("Trip deleted.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Trip parseTrip(String[] parts) {
        String tripId = parts[0];
        String destination = parts[1];
        Date startDate = parseDate(parts[2]);
        Date endDate = parseDate(parts[3]);
        List<String> accommodations = Arrays.asList(parts[4].split(";"));
        List<String> transportation = Arrays.asList(parts[5].split(";"));
        List<String> activities = Arrays.asList(parts[6].split(";"));

        return new Trip(tripId, destination, startDate, endDate, accommodations, transportation, activities);
    }

    private Date parseDate(String dateStr) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            return formatter.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void saveTripToFile(String username, Trip trip) {
        String filename = TRIP_FOLDER + username + "/" + username + "-trip.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(trip.toString());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}