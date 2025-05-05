package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Order;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {
}
