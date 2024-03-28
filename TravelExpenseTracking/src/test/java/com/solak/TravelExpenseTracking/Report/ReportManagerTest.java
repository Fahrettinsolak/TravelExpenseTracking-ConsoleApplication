package com.solak.TravelExpenseTracking.Report;

import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Before;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Unit tests for the ReportManager class.
 */
public class ReportManagerTest {

    // Streams to capture System.out and System.err for testing
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    /**
     * Setup method to redirect System.out and System.err to capture the output streams.
     */
    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    /**
     * Test case to verify the generation of a report.
     */
    @Test
    public void testGenerateReport() {
        ReportManager reportManager = new ReportManager();
        reportManager.generateReport();
        assertTrue(outContent.toString().contains("Report generated."));
    }

    /**
     * Test case to verify viewing reports when there are no reports available.
     */
    @Test
    public void testViewReportsWithNoReports() {
        ReportManager reportManager = new ReportManager();
        reportManager.viewReports();
        assertEquals("No reports available.\n", outContent.toString());
    }

    /**
     * Test case to verify showing trip expenses report when there is no expenses file.
     */
    @Test
    public void testShowTripExpensesReportWithNoExpensesFile() {
        ReportManager reportManager = new ReportManager();
        String tripId = "123";
        File file = new File("path/to/trip/expenses/" + tripId + "-expenses.txt");
        assertFalse(file.exists()); // Ensure the file doesn't exist
        reportManager.showTripExpensesReport(tripId);
        assertEquals("No expenses found for trip ID: " + tripId + "\n", outContent.toString());
    }

    /**
     * Test case to verify showing trip expenses report when there is an expenses file.
     */
    @Test
    public void testShowTripExpensesReportWithExpensesFile() {
        ReportManager reportManager = new ReportManager();
        String tripId = "456";
        File file = new File("path/to/trip/expenses/" + tripId + "-expenses.txt");
        assertTrue(file.exists()); // Assume the file exists for this test
        reportManager.showTripExpensesReport(tripId);
        // You might need to adjust the expected output according to your test data
        assertEquals("Expenses for trip ID " + tripId + ":\n", outContent.toString());
    }
}
