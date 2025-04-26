package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Sells;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellsRepository extends JpaRepository<Sells, Long> {
}