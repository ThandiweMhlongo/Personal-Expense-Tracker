package com.simplespend.creational;
import com.simplespend.model.DatabaseManager;

public class DatabaseSingleton {
    private static DatabaseManager instance;

    private DatabaseSingleton() {} // Private so nobody else can make one!

    public static synchronized DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager("jdbc:mysql://localhost:3306/simplespend");
        }
        return instance;
    }
}