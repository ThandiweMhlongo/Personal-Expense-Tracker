package com.simplespend.model;

public class DatabaseManager {
    private String connectionString;

    public DatabaseManager(String connectionString) {
        this.connectionString = connectionString;
    }

    public void backupData() {
        System.out.println("Backing up data to: " + connectionString);
    }

    public void restoreData() {
        System.out.println("Restoring data from: " + connectionString);
    }
}
