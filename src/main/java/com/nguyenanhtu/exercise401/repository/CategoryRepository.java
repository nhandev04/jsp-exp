package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}