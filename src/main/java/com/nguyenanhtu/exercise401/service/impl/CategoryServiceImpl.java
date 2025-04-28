package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.CategoryRequest;
import com.nguyenanhtu.exercise401.entity.Category;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.CategoryRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.CategoryService;

import lombok.AllArgsConstructor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> getCategoryById(UUID id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category createCategory(CategoryRequest request) {
        Category newCategory = new Category();

        newCategory.setCategoryName(request.getCategoryName());
        newCategory.setCategoryDescription(request.getCategoryDescription());
        newCategory.setIcon(request.getIcon());
        newCategory.setImage(request.getImage());
        newCategory.setPlaceholder(request.getPlaceholder());
        newCategory.setActive(request.getActive());

        if (request.getParentId() != null) {
            Category parentCategory = categoryRepository.findById(request.getParentId())
                    .orElse(null);
            newCategory.setParent(parentCategory);
        }

        if (request.getCreatedBy() != null) {
            StaffAccount createdAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElse(null);
            newCategory.setCreatedBy(createdAccount);
        }

        if (request.getUpdatedBy() != null) {
            StaffAccount updatedAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElse(null);
            newCategory.setUpdatedBy(updatedAccount);
        }

        return categoryRepository.save(newCategory);
    }

    @Override
    public Category updateCategory(UUID id, CategoryRequest request) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new RuntimeException("Category not found with id: " + id);
        }

        Category category = categoryOptional.get();

        category.setCategoryName(request.getCategoryName());
        category.setCategoryDescription(request.getCategoryDescription());
        category.setIcon(request.getIcon());
        category.setImage(request.getImage());
        category.setPlaceholder(request.getPlaceholder());
        category.setActive(request.getActive());

        if (request.getParentId() != null) {
            Category parentCategory = categoryRepository.findById(request.getParentId())
                    .orElse(null);
            category.setParent(parentCategory);
        } else {
            category.setParent(null);
        }

        if (request.getUpdatedBy() != null) {
            StaffAccount updatedAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElse(null);
            category.setUpdatedBy(updatedAccount);
        }

        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(UUID id) {
        categoryRepository.deleteById(id);
    }
}
