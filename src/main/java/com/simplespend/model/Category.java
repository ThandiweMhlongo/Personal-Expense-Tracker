package com.simplespend.model;

public class Category {
    private String categoryId;
    private String name;
    private boolean isDefault;

    public Category(String categoryId, String name, boolean isDefault) {
        this.categoryId = categoryId;
        this.name = name;
        this.isDefault = isDefault;
    }

    public void editName(String newName) { this.name = newName; }
    public String getName() { return name; }
}
