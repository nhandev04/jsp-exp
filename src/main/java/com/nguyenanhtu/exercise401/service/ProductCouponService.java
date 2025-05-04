package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.ProductCouponRequest;
import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductCouponService {
    List<ProductCoupon> getAllProductCoupons();
    
    Optional<ProductCoupon> getProductCouponById(UUID id);
    
    List<ProductCoupon> getProductCouponsByProductId(UUID productId);
    
    List<ProductCoupon> getProductCouponsByCouponId(UUID couponId);

    ProductCoupon addProductCoupon(ProductCouponRequest request);
    
    ProductCoupon updateProductCoupon(UUID id, ProductCouponRequest request);
    
    void deleteProductCoupon(UUID id);
}