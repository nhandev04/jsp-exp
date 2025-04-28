package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import com.nguyenanhtu.exercise401.service.ProductCouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/product-coupons")
public class ProductCouponController {

    @Autowired
    private ProductCouponService productCouponService;

    @GetMapping
    public ResponseEntity<List<ProductCoupon>> getAllProductCoupons() {
        List<ProductCoupon> productCoupons = productCouponService.getAllProductCoupons();
        return ResponseEntity.ok(productCoupons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCoupon> getProductCouponById(@PathVariable UUID id) {
        return productCouponService.getProductCouponById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductCoupon>> getProductCouponsByProductId(@PathVariable UUID productId) {
        List<ProductCoupon> productCoupons = productCouponService.getProductCouponsByProductId(productId);
        return ResponseEntity.ok(productCoupons);
    }

    @GetMapping("/coupon/{couponId}")
    public ResponseEntity<List<ProductCoupon>> getProductCouponsByCouponId(@PathVariable UUID couponId) {
        List<ProductCoupon> productCoupons = productCouponService.getProductCouponsByCouponId(couponId);
        return ResponseEntity.ok(productCoupons);
    }

    @PostMapping
    public ResponseEntity<ProductCoupon> addProductCoupon(@RequestBody ProductCoupon productCoupon) {
        ProductCoupon createdProductCoupon = productCouponService.addProductCoupon(productCoupon);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProductCoupon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductCoupon> updateProductCoupon(@PathVariable UUID id, @RequestBody ProductCoupon productCoupon) {
        productCoupon.setId(id);
        ProductCoupon updatedProductCoupon = productCouponService.updateProductCoupon(productCoupon);
        return ResponseEntity.ok(updatedProductCoupon);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductCoupon(@PathVariable UUID id) {
        productCouponService.deleteProductCoupon(id);
        return ResponseEntity.noContent().build();
    }
}