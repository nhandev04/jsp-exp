package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductCouponRepository extends JpaRepository<ProductCoupon, UUID> {
    @Query("SELECT pc FROM ProductCoupon pc WHERE pc.product.id = :productId")
    List<ProductCoupon> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT pc FROM ProductCoupon pc WHERE pc.coupon.id = :couponId")
    List<ProductCoupon> findByCouponId(@Param("couponId") UUID couponId);
}
