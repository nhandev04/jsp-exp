package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}