package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.OrderRequest;
import com.nguyenanhtu.exercise401.entity.Order;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrderService {
    List<Order> getAllOrders();

    Optional<Order> getOrderById(UUID id);

    Order addOrder(OrderRequest request);

    Order updateOrder(UUID id, OrderRequest request);

    void deleteOrder(UUID id);
}