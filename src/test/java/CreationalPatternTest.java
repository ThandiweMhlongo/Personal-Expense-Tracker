package com.simplespend.creational;

import com.simplespend.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreationalPatternTest {

    @Test
    void testSingleton() {
        DatabaseManager instance1 = DatabaseSingleton.getInstance();
        DatabaseManager instance2 = DatabaseSingleton.getInstance();
        assertSame(instance1, instance2, "Both instances should be the exact same object!");
    }

    @Test
    void testBuilder() {
        Expense expense = new ExpenseBuilder()
                .setId("E101")
                .setAmount(250.0)
                .setDesc("Lunch")
                .build();

        assertEquals(250.0, expense.getAmount());
        assertEquals("Lunch", expense.getDescription());
    }

    @Test
    void testSimpleFactory() {
        Category cat = CategoryFactory.createCategory("DEFAULT");
        assertEquals("General", cat.getName());
    }

    @Test
    void testPrototype() throws CloneNotSupportedException {
        ExpenseRegistry registry = new ExpenseRegistry();
        Expense original = new ExpenseBuilder().setId("1").setAmount(100).setDesc("Rent").build();
        registry.addPrototype("MonthlyRent", original);

        Expense clone = registry.createCopy("MonthlyRent");
        assertEquals(original.getAmount(), clone.getAmount());
        assertNotSame(original, clone, "The clone should be a new object, not the same one!");
    }
}
