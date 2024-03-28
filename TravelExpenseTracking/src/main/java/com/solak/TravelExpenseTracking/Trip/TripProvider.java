package com.solak.TravelExpenseTracking.Trip;

import java.util.List;

/**
 * Interface for managing trips in the travel expense tracking system.
 */
public interface TripProvider {

    /**
     * Creates a new trip for a specific user.
     *
     * @param username The username of the user creating the trip.
     * @param trip     The trip object containing details of the trip.
     */
    void createTrip(String username, Trip trip);

    /**
     * Retrieves a list of trips associated with a specific user.
     *
     * @param username The username of the user whose trips are to be viewed.
     * @return A list of Trip objects representing the trips of the specified user.
     */
    List<Trip> viewTrips(String username);

    /**
     * Edits an existing trip for a specific user.
     *
     * @param username The username of the user editing the trip.
     * @param trip     The updated Trip object containing modified trip details.
     */
    void editTrip(String username, Trip trip);

    /**
     * Deletes a trip associated with a specific user.
     *
     * @param username The username of the user deleting the trip.
     * @param tripId   The unique identifier of the trip to be deleted.
     */
    void deleteTrip(String username, String tripId);
}
