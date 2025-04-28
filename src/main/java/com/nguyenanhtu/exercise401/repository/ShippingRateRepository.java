package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ShippingRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ShippingRateRepository extends JpaRepository<ShippingRate, UUID> {
    @Query("SELECT sr FROM ShippingRate sr WHERE sr.shippingZone.id = :shippingZoneId")
    List<ShippingRate> findByShippingZoneId(@Param("shippingZoneId") UUID shippingZoneId);
}
