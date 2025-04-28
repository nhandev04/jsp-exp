package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.OrderStatus;
import com.nguyenanhtu.exercise401.repository.OrderStatusRepository;
import com.nguyenanhtu.exercise401.service.OrderStatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService {

    private final OrderStatusRepository orderStatusRepository;

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
    public OrderStatus addOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus updateOrderStatus(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public void deleteOrderStatus(UUID id) {
        orderStatusRepository.deleteById(id);
    }
}