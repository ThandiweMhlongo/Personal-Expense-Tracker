package com.simplespend.model;

public class Budget {
    private String budgetId;
    private double monthlyLimit;
    private String monthYear;

    public Budget(String budgetId, double monthlyLimit, String monthYear) {
        this.budgetId = budgetId;
        this.monthlyLimit = monthlyLimit;
        this.monthYear = monthYear;
    }

    public void setLimit(double limit) { this.monthlyLimit = limit; }
    public double getRemaining() { return monthlyLimit; }
}
