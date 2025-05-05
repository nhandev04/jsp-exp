package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.OrderItem;
import com.nguyenanhtu.exercise401.controller.request.OrderItemRequest;
import com.nguyenanhtu.exercise401.entity.Order;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.repository.OrderItemRepository;
import com.nguyenanhtu.exercise401.repository.OrderRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.service.OrderItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderItemServiceImpl implements OrderItemService {

    private final OrderItemRepository orderItemRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Override
    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    @Override
    public Optional<OrderItem> getOrderItemById(UUID id) {
        return orderItemRepository.findById(id);
    }

    @Override
    public List<OrderItem> getOrderItemsByOrderId(String orderId) {
        return orderItemRepository.findByOrderId(orderId);
    }

    @Override
    public OrderItem addOrderItem(OrderItemRequest request) {
        OrderItem orderItem = new OrderItem();
        return saveOrderItem(orderItem, request);
    }

    @Override
    public OrderItem updateOrderItem(UUID id, OrderItemRequest request) {
        OrderItem orderItem = orderItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order item not found with id: " + id));

        return saveOrderItem(orderItem, request);
    }

    @Override
    public void deleteOrderItem(UUID id) {
        orderItemRepository.deleteById(id);
    }

    private OrderItem saveOrderItem(OrderItem orderItem, OrderItemRequest request) {
        // Set basic properties
        orderItem.setPrice(request.getPrice());
        orderItem.setQuantity(request.getQuantity());

        // Set order if provided
        if (request.getOrderId() != null) {
            Order order = orderRepository.findById(UUID.fromString(request.getOrderId()))
                    .orElseThrow(() -> new RuntimeException("Order not found with id: " + request.getOrderId()));
            orderItem.setOrder(order);
        }

        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            orderItem.setProduct(product);
        }

        // Save and return the order item
        return orderItemRepository.save(orderItem);
    }
}