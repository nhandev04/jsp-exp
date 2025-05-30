package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.CouponRequest;
import com.nguyenanhtu.exercise401.entity.Coupon;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CouponService {
    List<Coupon> getAllCoupons();
    
    Optional<Coupon> getCouponById(UUID id);
    
    Optional<Coupon> getCouponByCode(String couponCode);

    Coupon addCoupon(CouponRequest request);
    
    Coupon updateCoupon(UUID id, CouponRequest request);
    
    void deleteCoupon(UUID id);
}