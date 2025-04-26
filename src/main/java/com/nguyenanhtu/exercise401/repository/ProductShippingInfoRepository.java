package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductShippingInfoRepository extends JpaRepository<ProductShippingInfo, Long> {
}