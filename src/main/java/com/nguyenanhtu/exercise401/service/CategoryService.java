package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final List<Category> categories = new ArrayList<>();

    public List<Category> getAllCategories() {
        return categories;
    }

    public Category createCategory(Category category) {
        categories.add(category);
        return category;
    }
}