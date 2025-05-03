package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.ProductSuplierRequest;
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
    public ResponseEntity<ProductSuplier> addProductSuplier(@RequestBody ProductSuplierRequest productSuplierRequest) {
        ProductSuplier createdProductSuplier = productSuplierService.addProductSuplier(productSuplierRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductSuplier);
    }

    @PutMapping("/{productId}/{supplierId}")
    public ResponseEntity<ProductSuplier> updateProductSuplier(
            @PathVariable UUID productId,
            @PathVariable UUID supplierId,
            @RequestBody ProductSuplierRequest productSuplierRequest) {
        try {
            ProductSuplierId id = new ProductSuplierId(productId, supplierId);
            ProductSuplier updatedProductSuplier = productSuplierService.updateProductSuplier(id, productSuplierRequest);
            return ResponseEntity.ok(updatedProductSuplier);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
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