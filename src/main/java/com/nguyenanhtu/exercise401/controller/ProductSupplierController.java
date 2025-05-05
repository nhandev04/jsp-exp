package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.ProductSupplierRequest;
import com.nguyenanhtu.exercise401.entity.ProductSupplier;
import com.nguyenanhtu.exercise401.service.ProductSupplierService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/product-suppliers")
public class ProductSupplierController {

    private final ProductSupplierService productSupplierService;

    @GetMapping
    public ResponseEntity<List<ProductSupplier>> getAllProductSuppliers() {
        List<ProductSupplier> productSuppliers = productSupplierService.getAllProductSuppliers();
        return ResponseEntity.ok(productSuppliers);
    }

    @GetMapping("/{productId}/{supplierId}")
    public ResponseEntity<ProductSupplier> getProductSupplierById(
            @PathVariable UUID productId,
            @PathVariable UUID supplierId) {
        return productSupplierService.getProductSupplierById(productId, supplierId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductSupplier>> getProductSuppliersByProductId(@PathVariable UUID productId) {
        List<ProductSupplier> productSuppliers = productSupplierService.getProductSuppliersByProductId(productId);
        return ResponseEntity.ok(productSuppliers);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<ProductSupplier>> getProductSuppliersBySupplierId(@PathVariable UUID supplierId) {
        List<ProductSupplier> productSuppliers = productSupplierService.getProductSuppliersBySupplierId(supplierId);
        return ResponseEntity.ok(productSuppliers);
    }

    @GetMapping("/product/{productId}/primary")
    public ResponseEntity<List<ProductSupplier>> getPrimarySuppliersByProductId(@PathVariable UUID productId) {
        List<ProductSupplier> primarySuppliers = productSupplierService.getPrimarySuppliersByProductId(productId);
        return ResponseEntity.ok(primarySuppliers);
    }

    @PostMapping
    public ResponseEntity<ProductSupplier> createProductSupplier(@RequestBody ProductSupplierRequest request) {
        ProductSupplier createdProductSupplier = productSupplierService.addProductSupplier(request);
        return new ResponseEntity<>(createdProductSupplier, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProductSupplier> updateProductSupplier(@RequestBody ProductSupplierRequest request) {
        return ResponseEntity.ok(productSupplierService.updateProductSupplier(request));
    }

    @DeleteMapping("/{productId}/{supplierId}")
    public ResponseEntity<Void> deleteProductSupplier(
            @PathVariable UUID productId,
            @PathVariable UUID supplierId) {
        productSupplierService.deleteProductSupplier(productId, supplierId);
        return ResponseEntity.noContent().build();
    }
}