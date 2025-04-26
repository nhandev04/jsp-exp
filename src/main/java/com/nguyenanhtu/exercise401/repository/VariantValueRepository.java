package com.nguyenanhtu.exercise401.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nguyenanhtu.exercise401.entity.VariantValue;

public interface VariantValueRepository extends JpaRepository<VariantValue, UUID> {
}