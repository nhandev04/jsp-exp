package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductCategory;
import com.nguyenanhtu.exercise401.repository.ProductCategoryRepository;
import com.nguyenanhtu.exercise401.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryRepository productCategoryRepository;

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
    public ProductCategory addProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public ProductCategory updateProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public void deleteProductCategory(UUID id) {
        productCategoryRepository.deleteById(id);
    }
}