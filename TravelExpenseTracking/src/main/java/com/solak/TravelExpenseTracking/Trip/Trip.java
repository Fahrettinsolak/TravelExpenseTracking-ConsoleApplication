package com.solak.TravelExpenseTracking.Trip;

import java.util.Date;
import java.util.List;

/**
 * The Trip class represents a travel trip with various details such as destination, dates, accommodations, transportation, and activities.
 */
public class Trip {
    private String tripId; // Unique identifier for the trip
    private String destination; // Destination of the trip
    private Date startDate; // Start date of the trip
    private Date endDate; // End date of the trip
    private List<String> accommodations; // List of accommodations during the trip
    private List<String> transportation; // List of transportation modes used during the trip
    private List<String> activities; // List of activities planned during the trip

    /**
     * Constructor to create a new Trip object with specified parameters.
     *
     * @param tripId           The unique identifier for the trip.
     * @param destination      The destination of the trip.
     * @param startDate        The start date of the trip.
     * @param endDate          The end date of the trip.
     * @param accommodations   The list of accommodations during the trip.
     * @param transportation   The list of transportation modes used during the trip.
     * @param activities       The list of activities planned during the trip.
     */
    public Trip(String tripId, String destination, Date startDate, Date endDate, List<String> accommodations, List<String> transportation, List<String> activities) {
        this.tripId = tripId;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accommodations = accommodations;
        this.transportation = transportation;
        this.activities = activities;
    }

    /**
     * Returns a string representation of the trip.
     *
     * @return A string containing trip details.
     */
    @Override
    public String toString() {
        return "Trip ID: " + tripId +
                ", Destination: " + destination +
                ", Start Date: " + startDate +
                ", End Date: " + endDate +
                ", Accommodations: " + accommodations +
                ", Transportation: " + transportation +
                ", Activities: " + activities;
    }

    // Getter and setter methods

    /**
     * Gets the trip ID.
     *
     * @return The trip ID.
     */
    public String getTripId() {
        return tripId;
    }

    /**
     * Sets the trip ID.
     *
     * @param tripId The trip ID to set.
     */
    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    /**
     * Gets the destination of the trip.
     *
     * @return The destination of the trip.
     */
    public String getDestination() {
        return destination;
    }

    /**
     * Sets the destination of the trip.
     *
     * @param destination The destination to set.
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * Gets the start date of the trip.
     *
     * @return The start date of the trip.
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date of the trip.
     *
     * @param startDate The start date to set.
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * Gets the end date of the trip.
     *
     * @return The end date of the trip.
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date of the trip.
     *
     * @param endDate The end date to set.
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the list of accommodations during the trip.
     *
     * @return The list of accommodations.
     */
    public List<String> getAccommodations() {
        return accommodations;
    }

    /**
     * Sets the list of accommodations during the trip.
     *
     * @param accommodations The list of accommodations to set.
     */
    public void setAccommodations(List<String> accommodations) {
        this.accommodations = accommodations;
    }

    /**
     * Gets the list of transportation modes used during the trip.
     *
     * @return The list of transportation modes.
     */
    public List<String> getTransportation() {
        return transportation;
    }

    /**
     * Sets the list of transportation modes used during the trip.
     *
     * @param transportation The list of transportation modes to set.
     */
    public void setTransportation(List<String> transportation) {
        this.transportation = transportation;
    }

    /**
     * Gets the list of activities planned during the trip.
     *
     * @return The list of activities.
     */
    public List<String> getActivities() {
        return activities;
    }

    /**
     * Sets the list of activities planned during the trip.
     *
     * @param activities The list of activities to set.
     */
    public void setActivities(List<String> activities) {
        this.activities = activities;
    }
}
