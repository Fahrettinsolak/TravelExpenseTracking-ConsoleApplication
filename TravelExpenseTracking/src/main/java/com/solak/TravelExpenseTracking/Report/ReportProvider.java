package com.solak.TravelExpenseTracking.Report;

/**
 * The ReportProvider interface represents a contract for generating and viewing reports.
 * Implementing classes must define methods to generate and view reports.
 */
public interface ReportProvider {

    /**
     * Generates a report.
     * Implementing classes should define the logic for generating the report.
     */
    void generateReport();

    /**
     * Displays previously generated reports.
     * Implementing classes should define the logic for viewing reports.
     */
    void viewReports();
}
