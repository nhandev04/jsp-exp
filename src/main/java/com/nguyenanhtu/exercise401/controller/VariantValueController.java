package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.VariantValueRequest;
import com.nguyenanhtu.exercise401.entity.VariantValue;
import com.nguyenanhtu.exercise401.service.VariantValueService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/variant-values")
public class VariantValueController {

    private final VariantValueService variantValueService;

    @GetMapping
    public ResponseEntity<List<VariantValue>> getAllVariantValues() {
        return ResponseEntity.ok(variantValueService.getAllVariantValues());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantValue> getVariantValueById(@PathVariable UUID id) {
        return variantValueService.getVariantValueById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/variant/{variantId}")
    public ResponseEntity<List<VariantValue>> getVariantValuesByVariantId(@PathVariable UUID variantId) {
        return ResponseEntity.ok(variantValueService.getVariantValuesByVariantId(variantId));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<VariantValue>> getVariantValuesByProductId(@PathVariable UUID productId) {
        return ResponseEntity.ok(variantValueService.getVariantValuesByProductId(productId));
    }

    @GetMapping("/product-attribute-value/{productAttributeValueId}")
    public ResponseEntity<List<VariantValue>> getVariantValuesByProductAttributeValueId(
            @PathVariable UUID productAttributeValueId) {
        return ResponseEntity.ok(
                variantValueService.getVariantValuesByProductAttributeValueId(productAttributeValueId));
    }

    @GetMapping("/attribute/{attributeId}")
    public ResponseEntity<List<VariantValue>> getVariantValuesByAttributeId(@PathVariable UUID attributeId) {
        return ResponseEntity.ok(variantValueService.getVariantValuesByAttributeId(attributeId));
    }

    @GetMapping("/attribute-value/{attributeValueId}")
    public ResponseEntity<List<VariantValue>> getVariantValuesByAttributeValueId(@PathVariable UUID attributeValueId) {
        return ResponseEntity.ok(variantValueService.getVariantValuesByAttributeValueId(attributeValueId));
    }

    @PostMapping
    public ResponseEntity<VariantValue> addVariantValue(@RequestBody VariantValueRequest request) {
        VariantValue createdVariantValue = variantValueService.addVariantValue(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVariantValue);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariantValue> updateVariantValue(@PathVariable UUID id,
            @RequestBody VariantValueRequest request) {
        try {
            VariantValue updatedVariantValue = variantValueService.updateVariantValue(id, request);
            return ResponseEntity.ok(updatedVariantValue);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariantValue(@PathVariable UUID id) {
        variantValueService.deleteVariantValue(id);
        return ResponseEntity.noContent().build();
    }
}