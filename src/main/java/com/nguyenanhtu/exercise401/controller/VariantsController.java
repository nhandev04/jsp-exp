package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.VariantsRequest;
import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.service.VariantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/variants")
public class VariantsController {

    @Autowired
    private VariantsService variantsService;

    @GetMapping
    public ResponseEntity<List<Variants>> getAllVariants() {
        List<Variants> variants = variantsService.getAllVariants();
        return ResponseEntity.ok(variants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Variants> getVariantById(@PathVariable UUID id) {
        return variantsService.getVariantById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Variants>> getVariantsByProductId(@PathVariable UUID productId) {
        List<Variants> variants = variantsService.getVariantsByProductId(productId);
        return ResponseEntity.ok(variants);
    }

    @PostMapping
    public ResponseEntity<Variants> addVariant(@RequestBody VariantsRequest variantsRequest) {
        Variants createdVariant = variantsService.addVariant(variantsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdVariant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Variants> updateVariant(@PathVariable UUID id, @RequestBody VariantsRequest variantsRequest) {
        try {
            Variants updatedVariant = variantsService.updateVariant(id, variantsRequest);
            return ResponseEntity.ok(updatedVariant);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVariant(@PathVariable UUID id) {
        variantsService.deleteVariant(id);
        return ResponseEntity.noContent().build();
    }
}