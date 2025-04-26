package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Category;
import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();

    Category createCategory(Category category);
}