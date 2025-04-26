package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Variants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VariantsRepository extends JpaRepository<Variants, Long> {
}