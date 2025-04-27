package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.CategoryRequest;
import com.nguyenanhtu.exercise401.entity.Category;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.CategoryRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.CategoryService;

import lombok.AllArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    private final StaffAccountRepository staffAccountRepository;

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
}