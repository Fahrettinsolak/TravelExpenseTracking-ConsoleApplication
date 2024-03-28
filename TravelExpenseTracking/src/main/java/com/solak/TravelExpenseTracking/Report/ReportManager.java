package com.solak.TravelExpenseTracking.Report;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReportManager implements ReportProvider {
    private List<Report> reports;
    
    public ReportManager() {
        reports = new ArrayList<>();
    }
    public List<Report> getReports() {
        return reports;
    }

    @Override
    public void generateReport() {
        // Belirtilen bir seyahat için rapor oluşturma işlemi burada gerçekleştirilir
        System.out.println("Report generated.");
    }

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

    public void showTripExpensesReport(String tripId) {
        String filePath = "path/to/trip/expenses/" + tripId + "-expenses.txt";
        File file = new File(filePath);

        if (!file.exists()) {
            System.out.println("No expenses found for trip ID: " + tripId);
            return;
        }

        System.out.println("Expenses for trip ID " + tripId + ":");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading expenses for trip ID " + tripId);
            e.printStackTrace();
        }
    }
}