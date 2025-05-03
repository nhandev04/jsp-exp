package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.ProductAttributeRequest;
import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import com.nguyenanhtu.exercise401.service.ProductAttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-attributes")
public class ProductAttributeController {

    @Autowired
    private ProductAttributeService productAttributeService;

    @GetMapping
    public ResponseEntity<List<ProductAttribute>> getAllProductAttributes() {
        List<ProductAttribute> productAttributes = productAttributeService.getAllProductAttributes();
        return ResponseEntity.ok(productAttributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductAttribute> getProductAttributeById(@PathVariable UUID id) {
        return productAttributeService.getProductAttributeById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductAttribute>> getProductAttributesByProductId(@PathVariable UUID productId) {
        List<ProductAttribute> productAttributes = productAttributeService.getProductAttributesByProductId(productId);
        return ResponseEntity.ok(productAttributes);
    }

    @GetMapping("/attribute/{attributeId}")
    public ResponseEntity<List<ProductAttribute>> getProductAttributesByAttributeId(@PathVariable UUID attributeId) {
        List<ProductAttribute> productAttributes = productAttributeService.getProductAttributesByAttributeId(attributeId);
        return ResponseEntity.ok(productAttributes);
    }

    @PostMapping
    public ResponseEntity<ProductAttribute> addProductAttribute(@RequestBody ProductAttributeRequest productAttributeRequest) {
        ProductAttribute createdProductAttribute = productAttributeService.addProductAttribute(productAttributeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductAttribute);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductAttribute> updateProductAttribute(@PathVariable UUID id, @RequestBody ProductAttributeRequest productAttributeRequest) {
        try {
            ProductAttribute updatedProductAttribute = productAttributeService.updateProductAttribute(id, productAttributeRequest);
            return ResponseEntity.ok(updatedProductAttribute);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductAttribute(@PathVariable UUID id) {
        productAttributeService.deleteProductAttribute(id);
        return ResponseEntity.noContent().build();
    }
}