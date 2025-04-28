package com.nguyenanhtu.exercise401.controller;

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
    public ResponseEntity<Sells> getSellsById(@PathVariable UUID id) {
        return sellsService.getSellsById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<Sells> getSellsByProductId(@PathVariable UUID productId) {
        return sellsService.getSellsByProductId(productId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sells> addSells(@RequestBody Sells sells) {
        Sells createdSells = sellsService.addSells(sells);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSells);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sells> updateSells(@PathVariable UUID id, @RequestBody Sells sells) {
        sells.setId(id);
        Sells updatedSells = sellsService.updateSells(sells);
        return ResponseEntity.ok(updatedSells);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSells(@PathVariable UUID id) {
        sellsService.deleteSells(id);
        return ResponseEntity.noContent().build();
    }
}