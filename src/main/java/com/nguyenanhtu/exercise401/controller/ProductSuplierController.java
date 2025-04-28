package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ProductSuplier;
import com.nguyenanhtu.exercise401.entity.ProductSuplier.ProductSuplierId;
import com.nguyenanhtu.exercise401.service.ProductSuplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-supliers")
public class ProductSuplierController {

    @Autowired
    private ProductSuplierService productSuplierService;

    @GetMapping
    public ResponseEntity<List<ProductSuplier>> getAllProductSupliers() {
        List<ProductSuplier> productSupliers = productSuplierService.getAllProductSupliers();
        return ResponseEntity.ok(productSupliers);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductSuplier>> getProductSupliersByProductId(@PathVariable UUID productId) {
        List<ProductSuplier> productSupliers = productSuplierService.getProductSupliersByProductId(productId);
        return ResponseEntity.ok(productSupliers);
    }

    @GetMapping("/supplier/{supplierId}")
    public ResponseEntity<List<ProductSuplier>> getProductSupliersBySupplierId(@PathVariable UUID supplierId) {
        List<ProductSuplier> productSupliers = productSuplierService.getProductSupliersBySupplierId(supplierId);
        return ResponseEntity.ok(productSupliers);
    }

    @GetMapping("/{productId}/{supplierId}")
    public ResponseEntity<ProductSuplier> getProductSuplierById(
            @PathVariable UUID productId,
            @PathVariable UUID supplierId) {
        ProductSuplierId id = new ProductSuplierId(productId, supplierId);
        return productSuplierService.getProductSuplierById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductSuplier> addProductSuplier(@RequestBody ProductSuplier productSuplier) {
        ProductSuplier createdProductSuplier = productSuplierService.addProductSuplier(productSuplier);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductSuplier);
    }

    @PutMapping
    public ResponseEntity<ProductSuplier> updateProductSuplier(@RequestBody ProductSuplier productSuplier) {
        ProductSuplier updatedProductSuplier = productSuplierService.updateProductSuplier(productSuplier);
        return ResponseEntity.ok(updatedProductSuplier);
    }

    @DeleteMapping("/{productId}/{supplierId}")
    public ResponseEntity<Void> deleteProductSuplier(
            @PathVariable UUID productId,
            @PathVariable UUID supplierId) {
        ProductSuplierId id = new ProductSuplierId(productId, supplierId);
        productSuplierService.deleteProductSuplier(id);
        return ResponseEntity.noContent().build();
    }
}