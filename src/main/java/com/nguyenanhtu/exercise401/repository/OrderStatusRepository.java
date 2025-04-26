package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
}