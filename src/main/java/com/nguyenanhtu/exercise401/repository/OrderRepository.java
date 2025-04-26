package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}