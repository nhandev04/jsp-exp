package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Category;
import com.nguyenanhtu.exercise401.repository.CategoryRepository;
import com.nguyenanhtu.exercise401.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }
}