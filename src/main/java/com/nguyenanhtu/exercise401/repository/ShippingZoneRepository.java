package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ShippingZone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShippingZoneRepository extends JpaRepository<ShippingZone, UUID> {
}
