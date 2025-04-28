package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import com.nguyenanhtu.exercise401.service.ProductAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-attribute-values")
public class ProductAttributeValueController {

    @Autowired
    private ProductAttributeValueService productAttributeValueService;

    @GetMapping
    public ResponseEntity<List<ProductAttributeValue>> getAllProductAttributeValues() {
        List<ProductAttributeValue> productAttributeValues = productAttributeValueService.getAllProductAttributeValues();
        return ResponseEntity.ok(productAttributeValues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttributeValue> getProductAttributeValueById(@PathVariable UUID id) {
        return productAttributeValueService.getProductAttributeValueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product-attribute/{productAttributeId}")
    public ResponseEntity<List<ProductAttributeValue>> getProductAttributeValuesByProductAttributeId(@PathVariable UUID productAttributeId) {
        List<ProductAttributeValue> productAttributeValues = productAttributeValueService.getProductAttributeValuesByProductAttributeId(productAttributeId);
        return ResponseEntity.ok(productAttributeValues);
    }

    @GetMapping("/attribute-value/{attributeValueId}")
    public ResponseEntity<List<ProductAttributeValue>> getProductAttributeValuesByAttributeValueId(@PathVariable UUID attributeValueId) {
        List<ProductAttributeValue> productAttributeValues = productAttributeValueService.getProductAttributeValuesByAttributeValueId(attributeValueId);
        return ResponseEntity.ok(productAttributeValues);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductAttributeValue>> getProductAttributeValuesByProductId(@PathVariable UUID productId) {
        List<ProductAttributeValue> productAttributeValues = productAttributeValueService.getProductAttributeValuesByProductId(productId);
        return ResponseEntity.ok(productAttributeValues);
    }

    @PostMapping
    public ResponseEntity<ProductAttributeValue> addProductAttributeValue(@RequestBody ProductAttributeValue productAttributeValue) {
        ProductAttributeValue createdProductAttributeValue = productAttributeValueService.addProductAttributeValue(productAttributeValue);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductAttributeValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttributeValue> updateProductAttributeValue(@PathVariable UUID id, @RequestBody ProductAttributeValue productAttributeValue) {
        productAttributeValue.setId(id);
        ProductAttributeValue updatedProductAttributeValue = productAttributeValueService.updateProductAttributeValue(productAttributeValue);
        return ResponseEntity.ok(updatedProductAttributeValue);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductAttributeValue(@PathVariable UUID id) {
        productAttributeValueService.deleteProductAttributeValue(id);
        return ResponseEntity.noContent().build();
    }
}