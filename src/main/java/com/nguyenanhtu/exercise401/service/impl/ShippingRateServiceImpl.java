package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ShippingRateRequest;
import com.nguyenanhtu.exercise401.entity.ShippingRate;
import com.nguyenanhtu.exercise401.entity.ShippingZone;
import com.nguyenanhtu.exercise401.repository.ShippingRateRepository;
import com.nguyenanhtu.exercise401.repository.ShippingZoneRepository;
import com.nguyenanhtu.exercise401.service.ShippingRateService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingRateServiceImpl implements ShippingRateService {

    private final ShippingRateRepository shippingRateRepository;
    private final ShippingZoneRepository shippingZoneRepository;

    @Override
    public List<ShippingRate> getAllShippingRates() {
        return shippingRateRepository.findAll();
    }

    @Override
    public Optional<ShippingRate> getShippingRateById(UUID id) {
        return shippingRateRepository.findById(id);
    }
    
    @Override
    public List<ShippingRate> getShippingRatesByShippingZoneId(UUID shippingZoneId) {
        return shippingRateRepository.findByShippingZoneId(shippingZoneId);
    }

    @Override
    public ShippingRate addShippingRate(ShippingRateRequest request) {
        ShippingRate shippingRate = new ShippingRate();
        return saveShippingRate(shippingRate, request);
    }

    @Override
    public ShippingRate updateShippingRate(UUID id, ShippingRateRequest request) {
        ShippingRate shippingRate = shippingRateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping rate not found with id: " + id));
        
        return saveShippingRate(shippingRate, request);
    }

    @Override
    public void deleteShippingRate(UUID id) {
        shippingRateRepository.deleteById(id);
    }
    
    private ShippingRate saveShippingRate(ShippingRate shippingRate, ShippingRateRequest request) {
        // Set basic properties
        shippingRate.setName(request.getName());
        shippingRate.setDescription(request.getDescription());
        shippingRate.setPrice(request.getPrice());
        shippingRate.setType(request.getType());
        
        // Set shipping zone if provided
        if (request.getShippingZoneId() != null) {
            ShippingZone shippingZone = shippingZoneRepository.findById(request.getShippingZoneId())
                    .orElseThrow(() -> new RuntimeException("Shipping zone not found with id: " + request.getShippingZoneId()));
            shippingRate.setShippingZone(shippingZone);
        }
        
        // Save and return the shipping rate
        return shippingRateRepository.save(shippingRate);
    }
}