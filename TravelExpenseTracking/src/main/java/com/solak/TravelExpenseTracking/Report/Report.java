package com.solak.TravelExpenseTracking.Report;

import java.util.Date;

/**
 * This class represents a report containing content and creation date.
 */
public class Report {
    private String content; // Content of the report
    private Date creationDate; // Date when the report was created

    /**
     * Constructs a new report with the given content and creation date.
     * @param content The content of the report
     * @param creationDate The date when the report was created
     */
    public Report(String content, Date creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }

    /**
     * Retrieves the content of the report.
     * @return The content of the report
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the content of the report.
     * @param content The content to be set
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Retrieves the creation date of the report.
     * @return The creation date of the report
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the creation date of the report.
     * @param creationDate The creation date to be set
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
