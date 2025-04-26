package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}