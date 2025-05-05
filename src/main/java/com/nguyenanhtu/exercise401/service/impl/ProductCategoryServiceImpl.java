package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductCategory;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.controller.request.ProductCategoryRequest;
import com.nguyenanhtu.exercise401.entity.Category;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.ProductCategoryRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.CategoryRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.ProductCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<ProductCategory> getAllProductCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Optional<ProductCategory> getProductCategoryById(UUID id) {
        return productCategoryRepository.findById(id);
    }

    @Override
    public List<ProductCategory> getProductCategoriesByProductId(UUID productId) {
        return productCategoryRepository.findByProductId(productId);
    }

    @Override
    public List<ProductCategory> getProductCategoriesByCategoryId(UUID categoryId) {
        return productCategoryRepository.findByCategoryId(categoryId);
    }

    @Override
    public ProductCategory addProductCategory(ProductCategoryRequest request) {
        ProductCategory productCategory = new ProductCategory();
        return saveProductCategory(productCategory, request);
    }

    @Override
    public ProductCategory updateProductCategory(UUID id, ProductCategoryRequest request) {
        ProductCategory productCategory = productCategoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product category not found with id: " + id));

        return saveProductCategory(productCategory, request);
    }

    @Override
    public void deleteProductCategory(UUID id) {
        productCategoryRepository.deleteById(id);
    }

    private ProductCategory saveProductCategory(ProductCategory productCategory, ProductCategoryRequest request) {
        // Set product if provided
        if (request.getProduct() != null) {
            Product product = productRepository.findById(request.getProduct())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProduct()));
            productCategory.setProduct(product);
        }

        // Set category if provided
        if (request.getCategory() != null) {
            Category category = categoryRepository.findById(request.getCategory())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + request.getCategory()));
            productCategory.setCategory(category);
        }

        // Set createdBy if provided and this is a new product category
        if (request.getCreatedBy() != null && productCategory.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            productCategory.setCreatedBy(createdByAccount);
        }

        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            productCategory.setUpdatedBy(updatedByAccount);
        }

        // Save and return the product category
        return productCategoryRepository.save(productCategory);
    }
}