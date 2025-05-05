package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.OrderStatusRequest;
import com.nguyenanhtu.exercise401.entity.OrderStatus;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.OrderStatusRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.OrderStatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<OrderStatus> getAllOrderStatuses() {
        return orderStatusRepository.findAll();
    }

    @Override
    public Optional<OrderStatus> getOrderStatusById(UUID id) {
        return orderStatusRepository.findById(id);
    }

    @Override
    public Optional<OrderStatus> getOrderStatusByName(String statusName) {
        return orderStatusRepository.findByStatusName(statusName);
    }

    @Override
    public OrderStatus addOrderStatus(OrderStatusRequest request) {
        OrderStatus orderStatus = new OrderStatus();
        return saveOrderStatus(orderStatus, request);
    }

    @Override
    public OrderStatus updateOrderStatus(UUID id, OrderStatusRequest request) {
        OrderStatus orderStatus = orderStatusRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order status not found with id: " + id));

        return saveOrderStatus(orderStatus, request);
    }

    @Override
    public void deleteOrderStatus(UUID id) {
        orderStatusRepository.deleteById(id);
    }

    private OrderStatus saveOrderStatus(OrderStatus orderStatus, OrderStatusRequest request) {
        // Set basic properties
        orderStatus.setStatusName(request.getStatusName());
        orderStatus.setColor(request.getColor());
        orderStatus.setPrivacy(request.getPrivacy());

        // Set createdBy if provided and this is a new order status
        if (request.getCreatedBy() != null && orderStatus.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            orderStatus.setCreatedBy(createdByAccount);
        }

        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            orderStatus.setUpdatedBy(updatedByAccount);
        }

        // Save and return the order status
        return orderStatusRepository.save(orderStatus);
    }
}