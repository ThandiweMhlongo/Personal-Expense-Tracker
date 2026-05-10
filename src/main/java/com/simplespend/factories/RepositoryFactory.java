package com.simplespend.factories;

import com.simplespend.repositories.*;
import com.simplespend.repositories.inmemory.*;
import com.simplespend.model.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RepositoryFactory {

    public static ExpenseRepository getExpenseRepository(String storageType) {
        if ("MEMORY".equalsIgnoreCase(storageType)) {
            return new InMemoryExpenseRepository();
        } else if ("DATABASE".equalsIgnoreCase(storageType)) {
            return new DatabaseExpenseRepositoryStub();
        }
        throw new IllegalArgumentException("Invalid storage type: " + storageType);
    }

    public static CategoryRepository getCategoryRepository(String storageType) {
        if ("MEMORY".equalsIgnoreCase(storageType)) {
            return new InMemoryCategoryRepository();
        }
        throw new IllegalArgumentException("Invalid storage type");
    }

    private static class DatabaseExpenseRepositoryStub implements ExpenseRepository {
        @Override
        public void save(Expense e) { System.out.println("SQL: INSERT INTO expenses..."); }

        @Override
        public Optional<Expense> findById(String id) { return Optional.empty(); }

        @Override
        public List<Expense> findAll() { return Collections.emptyList(); }

        @Override
        public void delete(String id) { System.out.println("SQL: DELETE FROM expenses..."); }
    }
}