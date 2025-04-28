package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.OrderStatus;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderStatusService {
    List<OrderStatus> getAllOrderStatuses();
    
    Optional<OrderStatus> getOrderStatusById(UUID id);
    
    Optional<OrderStatus> getOrderStatusByName(String statusName);
    
    OrderStatus addOrderStatus(OrderStatus orderStatus);
    
    OrderStatus updateOrderStatus(OrderStatus orderStatus);
    
    void deleteOrderStatus(UUID id);
}