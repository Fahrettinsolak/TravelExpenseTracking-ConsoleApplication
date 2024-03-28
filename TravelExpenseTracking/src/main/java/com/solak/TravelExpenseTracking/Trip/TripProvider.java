package com.solak.TravelExpenseTracking.Trip;

import java.util.List;

public interface TripProvider {
    void createTrip(String username, Trip trip);
    List<Trip> viewTrips(String username);
    void editTrip(String username, Trip trip);
    void deleteTrip(String username, String tripId);
}