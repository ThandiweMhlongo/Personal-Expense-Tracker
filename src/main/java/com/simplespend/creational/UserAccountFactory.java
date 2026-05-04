package com.simplespend.creational;
import com.simplespend.model.*;

public interface UserAccountFactory {
    User createUser();
    Budget createBudget();
}

class StandardUserFactory implements UserAccountFactory {
    public User createUser() { return new User("U1", "Guest", "hash1", "USD"); }
    public Budget createBudget() { return new Budget("B1", 500.0, "2026-05"); }
}