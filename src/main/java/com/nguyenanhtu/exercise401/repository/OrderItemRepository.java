package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}