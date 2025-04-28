package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import com.nguyenanhtu.exercise401.service.ProductShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-shipping-infos")
public class ProductShippingInfoController {

    @Autowired
    private ProductShippingInfoService productShippingInfoService;

    @GetMapping
    public ResponseEntity<List<ProductShippingInfo>> getAllProductShippingInfos() {
        List<ProductShippingInfo> productShippingInfos = productShippingInfoService.getAllProductShippingInfos();
        return ResponseEntity.ok(productShippingInfos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductShippingInfo> getProductShippingInfoById(@PathVariable UUID id) {
        return productShippingInfoService.getProductShippingInfoById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<ProductShippingInfo> getProductShippingInfoByProductId(@PathVariable UUID productId) {
        return productShippingInfoService.getProductShippingInfoByProductId(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductShippingInfo> addProductShippingInfo(@RequestBody ProductShippingInfo productShippingInfo) {
        ProductShippingInfo createdProductShippingInfo = productShippingInfoService.addProductShippingInfo(productShippingInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductShippingInfo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductShippingInfo> updateProductShippingInfo(@PathVariable UUID id, @RequestBody ProductShippingInfo productShippingInfo) {
        productShippingInfo.setId(id);
        ProductShippingInfo updatedProductShippingInfo = productShippingInfoService.updateProductShippingInfo(productShippingInfo);
        return ResponseEntity.ok(updatedProductShippingInfo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductShippingInfo(@PathVariable UUID id) {
        productShippingInfoService.deleteProductShippingInfo(id);
        return ResponseEntity.noContent().build();
    }
}