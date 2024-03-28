package com.solak.TravelExpenseTracking.Trip;

import java.util.Date;
import java.util.List;

public class Trip {
	private String tripId;
    private String destination;
    private Date startDate;
    private Date endDate;
    private List<String> accommodations;
    private List<String> transportation;
    private List<String> activities;

    // Constructor with parameters
    public Trip(String tripId, String destination, Date startDate, Date endDate, List<String> accommodations, List<String> transportation, List<String> activities) {
        this.tripId = tripId;
        this.destination = destination;
        this.startDate = startDate;
        this.endDate = endDate;
        this.accommodations = accommodations;
        this.transportation = transportation;
        this.activities = activities;
    }
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

    // Getter ve setter metotları
    public String getTripId() {
        return tripId;
    }

    public void setTripId(String tripId) {
        this.tripId = tripId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getAccommodations() {
        return accommodations;
    }

    public void setAccommodations(List<String> accommodations) {
        this.accommodations = accommodations;
    }

    public List<String> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<String> transportation) {
        this.transportation = transportation;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }
}
