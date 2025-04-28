package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.OrderStatus;
import com.nguyenanhtu.exercise401.service.OrderStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/order-statuses")
public class OrderStatusController {

    @Autowired
    private OrderStatusService orderStatusService;

    @GetMapping
    public ResponseEntity<List<OrderStatus>> getAllOrderStatuses() {
        List<OrderStatus> orderStatuses = orderStatusService.getAllOrderStatuses();
        return ResponseEntity.ok(orderStatuses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderStatus> getOrderStatusById(@PathVariable UUID id) {
        return orderStatusService.getOrderStatusById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/name/{statusName}")
    public ResponseEntity<OrderStatus> getOrderStatusByName(@PathVariable String statusName) {
        return orderStatusService.getOrderStatusByName(statusName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OrderStatus> addOrderStatus(@RequestBody OrderStatus orderStatus) {
        OrderStatus createdOrderStatus = orderStatusService.addOrderStatus(orderStatus);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrderStatus);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderStatus> updateOrderStatus(@PathVariable UUID id, @RequestBody OrderStatus orderStatus) {
        orderStatus.setId(id);
        OrderStatus updatedOrderStatus = orderStatusService.updateOrderStatus(orderStatus);
        return ResponseEntity.ok(updatedOrderStatus);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderStatus(@PathVariable UUID id) {
        orderStatusService.deleteOrderStatus(id);
        return ResponseEntity.noContent().build();
    }
}