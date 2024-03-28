package com.solak.TravelExpenseTracking.Report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ReportManager class manages the generation and viewing of reports related to travel expenses.
 */
public class ReportManager implements ReportProvider {
    private List<Report> reports; // List to store generated reports
    
    /**
     * Constructs a ReportManager object.
     */
    public ReportManager() {
        reports = new ArrayList<>(); // Initialize the list of reports
    }
    
    /**
     * Retrieves the list of reports.
     *
     * @return The list of reports.
     */
    public List<Report> getReports() {
        return reports;
    }

    /**
     * Generates a report.
     * This method is called to generate a report for a specified travel.
     */
    @Override
    public void generateReport() {
        // The process of generating a report for a specified travel is performed here
        System.out.println("Report generated.");
    }

    /**
     * Displays available reports.
     * If no reports are available, a message indicating so is printed; otherwise, each report's content and creation date are printed.
     */
    @Override
    public void viewReports() {
        if (reports.isEmpty()) {
            System.out.println("No reports available.");
        } else {
            System.out.println("Available reports:");
            for (Report report : reports) {
                System.out.println("Content: " + report.getContent() + ", Creation Date: " + report.getCreationDate());
            }
        }
    }

    /**
     * Displays expenses for a specific trip.
     *
     * @param tripId The ID of the trip for which expenses are to be displayed.
     */
    public void showTripExpensesReport(String tripId) {
        String filePath = "path/to/trip/expenses/" + tripId + "-expenses.txt"; // File path for the expenses of the trip
        File file = new File(filePath); // Creating a File object with the specified file path

        if (!file.exists()) { // Check if the file exists
            System.out.println("No expenses found for trip ID: " + tripId); // Print a message if no expenses are found
            return;
        }

        System.out.println("Expenses for trip ID " + tripId + ":"); // Print message indicating the trip ID for which expenses are displayed
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) { // Using try-with-resources to automatically close the BufferedReader
            String line;
            while ((line = reader.readLine()) != null) { // Reading each line from the file
                System.out.println(line); // Printing each line (expense)
            }
        } catch (IOException e) { // Catching any IOException that may occur during file reading
            System.out.println("An error occurred while reading expenses for trip ID " + tripId); // Print an error message if an exception occurs
            e.printStackTrace(); // Print the stack trace of the exception
        }
    }
}
