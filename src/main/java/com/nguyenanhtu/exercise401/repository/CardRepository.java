package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}