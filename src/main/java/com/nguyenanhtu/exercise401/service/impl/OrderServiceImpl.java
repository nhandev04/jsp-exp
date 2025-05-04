package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.OrderRequest;
import com.nguyenanhtu.exercise401.entity.Order;
import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.entity.Coupon;
import com.nguyenanhtu.exercise401.entity.OrderStatus;
import com.nguyenanhtu.exercise401.repository.OrderRepository;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import com.nguyenanhtu.exercise401.repository.CouponRepository;
import com.nguyenanhtu.exercise401.repository.OrderStatusRepository;
import com.nguyenanhtu.exercise401.service.OrderService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CouponRepository couponRepository;
    private final OrderStatusRepository orderStatusRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(String id) {
        return orderRepository.findById(id);
    }

    @Override
    public Order addOrder(OrderRequest request) {
        Order order = new Order();
        return saveOrder(order, request);
    }

    @Override
    public Order updateOrder(String id, OrderRequest request) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + id));
        
        return saveOrder(order, request);
    }

    @Override
    public void deleteOrder(String id) {
        orderRepository.deleteById(id);
    }
    
    private Order saveOrder(Order order, OrderRequest request) {
        // Set ID for new orders
        if (order.getId() == null) {
            order.setId(request.getId());
        }
        
        // Set customer if provided
        if (request.getCustomerId() != null) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomerId()));
            order.setCustomer(customer);
        }
        
        // Set coupon if provided
        if (request.getCouponId() != null) {
            Coupon coupon = couponRepository.findById(request.getCouponId())
                    .orElseThrow(() -> new RuntimeException("Coupon not found with id: " + request.getCouponId()));
            order.setCoupon(coupon);
        }
        
        // Set order status if provided
        if (request.getOrderStatusId() != null) {
            OrderStatus orderStatus = orderStatusRepository.findById(request.getOrderStatusId())
                    .orElseThrow(() -> new RuntimeException("Order status not found with id: " + request.getOrderStatusId()));
            order.setOrderStatus(orderStatus);
        }
        
        // Set order dates
        if (request.getOrderApprovedAt() != null) {
            order.setOrderApprovedAt(request.getOrderApprovedAt());
        }
        
        if (request.getOrderDeliveredCarrierDate() != null) {
            order.setOrderDeliveredCarrierDate(request.getOrderDeliveredCarrierDate());
        }
        
        if (request.getOrderDeliveredCustomerDate() != null) {
            order.setOrderDeliveredCustomerDate(request.getOrderDeliveredCustomerDate());
        }
        
        // Save and return the order
        return orderRepository.save(order);
    }
}