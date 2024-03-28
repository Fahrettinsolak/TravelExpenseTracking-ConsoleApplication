package com.solak.TravelExpenseTracking.Budget;

/**
 * This class generates budget proposals based on specific travel type and destination.
 */
public class BudgetProposalGenerator {

    /**
     * Method to create a budget proposal based on a given trip type and destination.
     * 
     * @param tripType     The type of the trip (e.g., "city", "beach").
     * @param destination  The destination of the trip (e.g., "Europe", "Asia").
     * @return             A Budget object representing the proposed budget.
     */
    public Budget createBudgetProposal(String tripType, String destination) {
        // Average expenditure values
        double averageAccommodationCost;
        double averageTransportationCost;
        double averageFoodCost;

        // Determining average accommodation cost based on trip type
        if (tripType.equalsIgnoreCase("city")) {
            averageAccommodationCost = 100; // Average accommodation cost for city trips
        } else if (tripType.equalsIgnoreCase("beach")) {
            averageAccommodationCost = 150; // Average accommodation cost for beach vacations
        } else {
            averageAccommodationCost = 120; // Default value
        }

        // Determining average transportation cost based on destination
        if (destination.equalsIgnoreCase("Europe")) {
            averageTransportationCost = 200; // Average transportation cost for European trips
        } else if (destination.equalsIgnoreCase("Asia")) {
            averageTransportationCost = 250; // Average transportation cost for Asian trips
        } else {
            averageTransportationCost = 220; // Default value
        }

        // Average food cost
        averageFoodCost = 30; // Average cost of one meal

        // Calculating total average expenditure
        double totalAverageCost = averageAccommodationCost + averageTransportationCost + averageFoodCost;

        // Creating a budget proposal
        Budget budgetProposal = new Budget(totalAverageCost, "USD", "Average expenses based on trip type and destination", "Per Person", "Total");

        return budgetProposal;
    }
}
