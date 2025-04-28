package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.ShippingZone;
import com.nguyenanhtu.exercise401.service.ShippingZoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shipping-zones")
public class ShippingZoneController {

    @Autowired
    private ShippingZoneService shippingZoneService;

    @GetMapping
    public ResponseEntity<List<ShippingZone>> getAllShippingZones() {
        List<ShippingZone> shippingZones = shippingZoneService.getAllShippingZones();
        return ResponseEntity.ok(shippingZones);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingZone> getShippingZoneById(@PathVariable UUID id) {
        return shippingZoneService.getShippingZoneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ShippingZone> addShippingZone(@RequestBody ShippingZone shippingZone) {
        ShippingZone createdShippingZone = shippingZoneService.addShippingZone(shippingZone);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingZone);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingZone> updateShippingZone(@PathVariable UUID id, @RequestBody ShippingZone shippingZone) {
        shippingZone.setId(id);
        ShippingZone updatedShippingZone = shippingZoneService.updateShippingZone(shippingZone);
        return ResponseEntity.ok(updatedShippingZone);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingZone(@PathVariable UUID id) {
        shippingZoneService.deleteShippingZone(id);
        return ResponseEntity.noContent().build();
    }
}