package com.simplespend.creational;
import com.simplespend.model.Expense;
import java.util.HashMap;
import java.util.Map;

public class ExpenseRegistry {
    private Map<String, Expense> prototypes = new HashMap<>();

    public void addPrototype(String key, Expense e) { prototypes.put(key, e); }

    public Expense createCopy(String key) throws CloneNotSupportedException {
        return (Expense) prototypes.get(key).clone();
    }
}
