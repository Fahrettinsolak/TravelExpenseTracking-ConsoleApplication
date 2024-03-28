package com.solak.TravelExpenseTracking.Budget;

public class Budget {
    private double amount;
    private String currency;
    private String description;
    private String type;
    private String category;
    // Diğer bütçe bilgileri buraya eklenebilir

    // Parametre alan yapıcı metod
    public Budget(double amount, String currency, String description, String type, String category) {
        this.amount = amount;
        this.currency = currency;
        this.description = description;
        this.type = type;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
