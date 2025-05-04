package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.CategoryRequest;
import com.nguyenanhtu.exercise401.entity.Category;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CategoryService {
    List<Category> getAllCategories();
    
    Optional<Category> getCategoryById(UUID id);

    Category createCategory(CategoryRequest request);
    
    Category updateCategory(UUID id, CategoryRequest request);
    
    void deleteCategory(UUID id);
}
