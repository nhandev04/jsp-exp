package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.OrderRequest;
import com.nguyenanhtu.exercise401.entity.Order;
import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> getAllOrders();
    
    Optional<Order> getOrderById(String id);

    Order addOrder(OrderRequest request);
    
    Order updateOrder(String id, OrderRequest request);
    
    void deleteOrder(String id);
}