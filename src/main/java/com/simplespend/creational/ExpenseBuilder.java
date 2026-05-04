package com.simplespend.creational;
import com.simplespend.model.Expense;
import java.util.Date;

public class ExpenseBuilder {
    private String id;
    private double amount;
    private String desc;

    public ExpenseBuilder setId(String id) { this.id = id; return this; }
    public ExpenseBuilder setAmount(double amount) { this.amount = amount; return this; }
    public ExpenseBuilder setDesc(String desc) { this.desc = desc; return this; }

    public Expense build() {
        return new Expense(id, amount, new Date(), desc);
    }
}