package com.solak.TravelExpenseTracking.Report;

import java.util.Date;

public class Report {
    private String content;
    private Date creationDate;

    public Report(String content, Date creationDate) {
        this.content = content;
        this.creationDate = creationDate;
    }

    // Getter ve setter metotları
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}