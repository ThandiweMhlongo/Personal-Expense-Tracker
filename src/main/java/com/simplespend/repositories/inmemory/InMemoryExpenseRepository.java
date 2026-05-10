package com.simplespend.repositories.inmemory;

import com.simplespend.model.Expense;
import com.simplespend.repositories.ExpenseRepository;
import java.util.*;

public class InMemoryExpenseRepository implements ExpenseRepository {
    private final Map<String, Expense> storage = new HashMap<>();

    @Override
    public void save(Expense entity) {
        storage.put(entity.getExpenseId(), entity);
        System.out.println("Saved Expense: " + entity.getExpenseId());
    }

    @Override
    public Optional<Expense> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<Expense> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public void delete(String id) {
        storage.remove(id);
    }
}