package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductCategory;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCategoryService {
    List<ProductCategory> getAllProductCategories();
    
    Optional<ProductCategory> getProductCategoryById(UUID id);
    
    List<ProductCategory> getProductCategoriesByProductId(UUID productId);
    
    List<ProductCategory> getProductCategoriesByCategoryId(UUID categoryId);
    
    ProductCategory addProductCategory(ProductCategory productCategory);
    
    ProductCategory updateProductCategory(ProductCategory productCategory);
    
    void deleteProductCategory(UUID id);
}