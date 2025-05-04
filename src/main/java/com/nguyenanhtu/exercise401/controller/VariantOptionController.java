package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.VariantOptionRequest;
import com.nguyenanhtu.exercise401.entity.VariantOption;
import com.nguyenanhtu.exercise401.service.VariantOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variant-options")
public class VariantOptionController {

    @Autowired
    private VariantOptionService variantOptionService;

    @GetMapping
    public ResponseEntity<List<VariantOption>> getAllVariantOptions() {
        List<VariantOption> variantOptions = variantOptionService.getAllVariantOptions();
        return ResponseEntity.ok(variantOptions);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VariantOption> getVariantOptionById(@PathVariable UUID id) {
        return variantOptionService.getVariantOptionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<VariantOption>> getVariantOptionsByProductId(@PathVariable UUID productId) {
        List<VariantOption> variantOptions = variantOptionService.getVariantOptionsByProductId(productId);
        return ResponseEntity.ok(variantOptions);
    }

    @PostMapping
    public ResponseEntity<VariantOption> addVariantOption(@RequestBody VariantOptionRequest variantOptionRequest) {
        VariantOption createdVariantOption = variantOptionService.addVariantOption(variantOptionRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVariantOption);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VariantOption> updateVariantOption(@PathVariable UUID id, @RequestBody VariantOptionRequest variantOptionRequest) {
        try {
            VariantOption updatedVariantOption = variantOptionService.updateVariantOption(id, variantOptionRequest);
            return ResponseEntity.ok(updatedVariantOption);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariantOption(@PathVariable UUID id) {
        variantOptionService.deleteVariantOption(id);
        return ResponseEntity.noContent().build();
    }
}