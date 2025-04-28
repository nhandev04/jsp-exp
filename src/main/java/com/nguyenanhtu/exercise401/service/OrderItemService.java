package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.OrderItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    
    Optional<OrderItem> getOrderItemById(UUID id);
    
    List<OrderItem> getOrderItemsByOrderId(String orderId);
    
    OrderItem addOrderItem(OrderItem orderItem);
    
    OrderItem updateOrderItem(OrderItem orderItem);
    
    void deleteOrderItem(UUID id);
}