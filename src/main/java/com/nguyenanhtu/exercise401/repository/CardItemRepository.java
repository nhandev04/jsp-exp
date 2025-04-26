package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardItemRepository extends JpaRepository<CardItem, Long> {
}