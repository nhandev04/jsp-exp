package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.CouponRequest;
import com.nguyenanhtu.exercise401.entity.Coupon;
import com.nguyenanhtu.exercise401.repository.CouponRepository;
import com.nguyenanhtu.exercise401.service.CouponService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public List<Coupon> getAllCoupons() {
        return couponRepository.findAll();
    }

    @Override
    public Optional<Coupon> getCouponById(UUID id) {
        return couponRepository.findById(id);
    }

    @Override
    public Optional<Coupon> getCouponByCode(String couponCode) {
        return couponRepository.findByCode(couponCode);
    }

    @Override
    public Coupon addCoupon(CouponRequest request) {
        Coupon coupon = new Coupon();
        return saveCoupon(coupon, request);
    }

    @Override
    public Coupon updateCoupon(UUID id, CouponRequest request) {
        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found with id: " + id));

        return saveCoupon(coupon, request);
    }

    @Override
    public void deleteCoupon(UUID id) {
        couponRepository.deleteById(id);
    }

    private Coupon saveCoupon(Coupon coupon, CouponRequest request) {
        // Set basic properties
        if (request.getCode() != null) {
            coupon.setCode(request.getCode());
        }
        if (request.getType() != null) {
            coupon.setDiscountType(request.getType());
        }
        if (request.getValue() != null) {
            coupon.setDiscountValue(BigDecimal.valueOf(request.getValue()));
        }
        if (request.getMinOrderAmount() != null) {
            coupon.setOrderAmountLimit(BigDecimal.valueOf(request.getMinOrderAmount()));
        }
        if (request.getMaxUses() != null) {
            coupon.setMaxUsage(BigDecimal.valueOf(request.getMaxUses()));
        }
        if (request.getUsesCount() != null) {
            coupon.setTimesUsed(BigDecimal.valueOf(request.getUsesCount()));
        } else {
            coupon.setTimesUsed(BigDecimal.ZERO);
        }
        if (request.getExpiryDate() != null) {
            coupon.setCouponEndDate(request.getExpiryDate());
        }

        // Save and return the coupon
        return couponRepository.save(coupon);
    }
}