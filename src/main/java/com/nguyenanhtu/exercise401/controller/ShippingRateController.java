package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.ShippingRateRequest;
import com.nguyenanhtu.exercise401.entity.ShippingRate;
import com.nguyenanhtu.exercise401.service.ShippingRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/shipping-rates")
public class ShippingRateController {

    @Autowired
    private ShippingRateService shippingRateService;

    @GetMapping
    public ResponseEntity<List<ShippingRate>> getAllShippingRates() {
        List<ShippingRate> shippingRates = shippingRateService.getAllShippingRates();
        return ResponseEntity.ok(shippingRates);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShippingRate> getShippingRateById(@PathVariable UUID id) {
        return shippingRateService.getShippingRateById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/shipping-zone/{shippingZoneId}")
    public ResponseEntity<List<ShippingRate>> getShippingRatesByShippingZoneId(@PathVariable UUID shippingZoneId) {
        List<ShippingRate> shippingRates = shippingRateService.getShippingRatesByShippingZoneId(shippingZoneId);
        return ResponseEntity.ok(shippingRates);
    }

    @PostMapping
    public ResponseEntity<ShippingRate> addShippingRate(@RequestBody ShippingRateRequest shippingRateRequest) {
        ShippingRate createdShippingRate = shippingRateService.addShippingRate(shippingRateRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdShippingRate);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ShippingRate> updateShippingRate(@PathVariable UUID id, @RequestBody ShippingRateRequest shippingRateRequest) {
        try {
            ShippingRate updatedShippingRate = shippingRateService.updateShippingRate(id, shippingRateRequest);
            return ResponseEntity.ok(updatedShippingRate);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShippingRate(@PathVariable UUID id) {
        shippingRateService.deleteShippingRate(id);
        return ResponseEntity.noContent().build();
    }
}