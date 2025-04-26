package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeRepository extends JpaRepository<Attribute, Long> {
}