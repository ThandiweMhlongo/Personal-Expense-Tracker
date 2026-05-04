package com.simplespend.model;
import java.util.Date;

public class Expense implements Cloneable {
    private String expenseId;
    private double amount;
    private Date date;
    private String description;

    public Expense(String expenseId, double amount, Date date, String description) {
        this.expenseId = expenseId;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public void save() { System.out.println("Expense saved."); }
    public void update() { System.out.println("Expense updated."); }
    public void remove() { System.out.println("Expense removed."); }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public double getAmount() { return amount; }
    public String getDescription() { return description; }
}