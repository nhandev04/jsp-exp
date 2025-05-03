package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.OrderStatusRequest;
import com.nguyenanhtu.exercise401.entity.OrderStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderStatusService {
    List<OrderStatus> getAllOrderStatuses();
    
    Optional<OrderStatus> getOrderStatusById(UUID id);
    
    Optional<OrderStatus> getOrderStatusByName(String statusName);

    OrderStatus addOrderStatus(OrderStatusRequest request);
    
    OrderStatus updateOrderStatus(UUID id, OrderStatusRequest request);
    
    void deleteOrderStatus(UUID id);
}