package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductCoupon;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.controller.request.ProductCouponRequest;
import com.nguyenanhtu.exercise401.entity.Coupon;
import com.nguyenanhtu.exercise401.repository.ProductCouponRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.CouponRepository;
import com.nguyenanhtu.exercise401.service.ProductCouponService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductCouponServiceImpl implements ProductCouponService {

    private final ProductCouponRepository productCouponRepository;
    private final ProductRepository productRepository;
    private final CouponRepository couponRepository;

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
    public ProductCoupon addProductCoupon(ProductCouponRequest request) {
        ProductCoupon productCoupon = new ProductCoupon();
        return saveProductCoupon(productCoupon, request);
    }

    @Override
    public ProductCoupon updateProductCoupon(UUID id, ProductCouponRequest request) {
        ProductCoupon productCoupon = productCouponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product coupon not found with id: " + id));
        
        return saveProductCoupon(productCoupon, request);
    }

    @Override
    public void deleteProductCoupon(UUID id) {
        productCouponRepository.deleteById(id);
    }
    
    private ProductCoupon saveProductCoupon(ProductCoupon productCoupon, ProductCouponRequest request) {
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            productCoupon.setProduct(product);
        }
        
        // Set coupon if provided
        if (request.getCouponId() != null) {
            Coupon coupon = couponRepository.findById(request.getCouponId())
                    .orElseThrow(() -> new RuntimeException("Coupon not found with id: " + request.getCouponId()));
            productCoupon.setCoupon(coupon);
        }
        
        // Save and return the product coupon
        return productCouponRepository.save(productCoupon);
    }
}