package com.simplespend.model;

public class User {
    private String userId;
    private String username;
    private String passwordHash;
    private String currencyPreference;

    public User(String userId, String username, String passwordHash, String currencyPreference) {
        this.userId = userId;
        this.username = username;
        this.passwordHash = passwordHash;
        this.currencyPreference = currencyPreference;
    }

    public void register() { System.out.println("User " + username + " registered."); }
    public void login() { System.out.println("User " + username + " logged in."); }
    public void updateProfile() { System.out.println("Profile updated."); }

    // Getters and Setters
    public String getUserId() { return userId; }
    public String getUsername() { return username; }
}
