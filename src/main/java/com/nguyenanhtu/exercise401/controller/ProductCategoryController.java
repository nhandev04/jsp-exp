package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ProductCategory;
import com.nguyenanhtu.exercise401.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-categories")
public class ProductCategoryController {

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping
    public ResponseEntity<List<ProductCategory>> getAllProductCategories() {
        List<ProductCategory> productCategories = productCategoryService.getAllProductCategories();
        return ResponseEntity.ok(productCategories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> getProductCategoryById(@PathVariable UUID id) {
        return productCategoryService.getProductCategoryById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductCategory>> getProductCategoriesByProductId(@PathVariable UUID productId) {
        List<ProductCategory> productCategories = productCategoryService.getProductCategoriesByProductId(productId);
        return ResponseEntity.ok(productCategories);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<ProductCategory>> getProductCategoriesByCategoryId(@PathVariable UUID categoryId) {
        List<ProductCategory> productCategories = productCategoryService.getProductCategoriesByCategoryId(categoryId);
        return ResponseEntity.ok(productCategories);
    }

    @PostMapping
    public ResponseEntity<ProductCategory> addProductCategory(@RequestBody ProductCategory productCategory) {
        ProductCategory createdProductCategory = productCategoryService.addProductCategory(productCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCategory> updateProductCategory(@PathVariable UUID id, @RequestBody ProductCategory productCategory) {
        productCategory.setId(id);
        ProductCategory updatedProductCategory = productCategoryService.updateProductCategory(productCategory);
        return ResponseEntity.ok(updatedProductCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCategory(@PathVariable UUID id) {
        productCategoryService.deleteProductCategory(id);
        return ResponseEntity.noContent().build();
    }
}