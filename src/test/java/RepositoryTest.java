package com.simplespend;

import com.simplespend.model.Expense;
import com.simplespend.repositories.ExpenseRepository;
import com.simplespend.factories.RepositoryFactory;
import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class RepositoryTest {

    @Test
    void testExpenseCRUD() {
        // 1. Get repository via Factory
        ExpenseRepository repo = RepositoryFactory.getExpenseRepository("MEMORY");

        // 2. Create and Save
        Expense dinner = new Expense("EXP001", 45.50, new Date(), "Dinner");
        repo.save(dinner);

        // 3. Read (FindById)
        Optional<Expense> fetched = repo.findById("EXP001");
        assertTrue(fetched.isPresent(), "Expense should be found in memory");
        assertEquals(45.50, fetched.get().getAmount());

        // 4. Read All
        List<Expense> allExpenses = repo.findAll();
        assertEquals(1, allExpenses.size());

        // 5. Delete
        repo.delete("EXP001");
        assertFalse(repo.findById("EXP001").isPresent(), "Expense should be deleted");
    }
}