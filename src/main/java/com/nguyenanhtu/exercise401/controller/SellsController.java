package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.SellsRequest;
import com.nguyenanhtu.exercise401.entity.Sells;
import com.nguyenanhtu.exercise401.service.SellsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sells")
public class SellsController {

    @Autowired
    private SellsService sellsService;

    @GetMapping
    public ResponseEntity<List<Sells>> getAllSells() {
        List<Sells> sells = sellsService.getAllSells();
        return ResponseEntity.ok(sells);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sells> getSellById(@PathVariable UUID id) {
        return sellsService.getSellById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<Sells>> getSellsByProductId(@PathVariable UUID productId) {
        List<Sells> sells = sellsService.getSellsByProductId(productId);
        return ResponseEntity.ok(sells);
    }

    @PostMapping
    public ResponseEntity<Sells> addSell(@RequestBody SellsRequest sellsRequest) {
        Sells createdSell = sellsService.addSell(sellsRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSell);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sells> updateSell(@PathVariable UUID id, @RequestBody SellsRequest sellsRequest) {
        try {
            Sells updatedSell = sellsService.updateSell(id, sellsRequest);
            return ResponseEntity.ok(updatedSell);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSell(@PathVariable UUID id) {
        sellsService.deleteSell(id);
        return ResponseEntity.noContent().build();
    }
}