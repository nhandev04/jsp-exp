package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCouponService {
    List<ProductCoupon> getAllProductCoupons();
    
    Optional<ProductCoupon> getProductCouponById(UUID id);
    
    List<ProductCoupon> getProductCouponsByProductId(UUID productId);
    
    List<ProductCoupon> getProductCouponsByCouponId(UUID couponId);
    
    ProductCoupon addProductCoupon(ProductCoupon productCoupon);
    
    ProductCoupon updateProductCoupon(ProductCoupon productCoupon);
    
    void deleteProductCoupon(UUID id);
}