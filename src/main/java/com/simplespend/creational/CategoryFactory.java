package com.simplespend.creational;
import com.simplespend.model.Category;

public class CategoryFactory {
    public static Category createCategory(String type) {
        if (type.equalsIgnoreCase("DEFAULT")) {
            return new Category("CAT001", "General", true);
        } else {
            return new Category("CAT002", "Custom", false);
        }
    }
}