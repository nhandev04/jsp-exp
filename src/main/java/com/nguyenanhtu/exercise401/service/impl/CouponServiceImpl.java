package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Coupon;
import com.nguyenanhtu.exercise401.repository.CouponRepository;
import com.nguyenanhtu.exercise401.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
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
    public Optional<Coupon> getCouponByCode(String code) {
        return couponRepository.findByCode(code);
    }

    @Override
    public Coupon addCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    @Override
    public void deleteCoupon(UUID id) {
        couponRepository.deleteById(id);
    }
}