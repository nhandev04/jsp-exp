package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ShippingRate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingRateRepository extends JpaRepository<ShippingRate, Long> {
}