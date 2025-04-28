package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import com.nguyenanhtu.exercise401.repository.ProductCouponRepository;
import com.nguyenanhtu.exercise401.service.ProductCouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductCouponServiceImpl implements ProductCouponService {

    private final ProductCouponRepository productCouponRepository;

    @Override
    public List<ProductCoupon> getAllProductCoupons() {
        return productCouponRepository.findAll();
    }

    @Override
    public Optional<ProductCoupon> getProductCouponById(UUID id) {
        return productCouponRepository.findById(id);
    }

    @Override
    public List<ProductCoupon> getProductCouponsByProductId(UUID productId) {
        return productCouponRepository.findByProductId(productId);
    }

    @Override
    public List<ProductCoupon> getProductCouponsByCouponId(UUID couponId) {
        return productCouponRepository.findByCouponId(couponId);
    }

    @Override
    public ProductCoupon addProductCoupon(ProductCoupon productCoupon) {
        return productCouponRepository.save(productCoupon);
    }

    @Override
    public ProductCoupon updateProductCoupon(ProductCoupon productCoupon) {
        return productCouponRepository.save(productCoupon);
    }

    @Override
    public void deleteProductCoupon(UUID id) {
        productCouponRepository.deleteById(id);
    }
}