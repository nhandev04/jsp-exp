package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.ShippingRateRequest;
import com.nguyenanhtu.exercise401.entity.ShippingRate;
import com.nguyenanhtu.exercise401.entity.ShippingZone;
import com.nguyenanhtu.exercise401.repository.ShippingRateRepository;
import com.nguyenanhtu.exercise401.repository.ShippingZoneRepository;
import com.nguyenanhtu.exercise401.service.ShippingRateService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
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
        shippingRate.setPrice(request.getPrice());
        
        // Set weight-related properties if provided
        if (request.getMinValue() != null) {
            shippingRate.setMinValue(request.getMinValue());
        }
        
        if (request.getMaxValue() != null) {
            shippingRate.setMaxValue(request.getMaxValue());
        }
        
        if (request.getNoMax() != null) {
            shippingRate.setNoMax(request.getNoMax());
        }
        
        // We can't directly access the private enum, so we'll pass the string to the setter
        // which will handle the conversion internally using the proper enum
        // This avoids the "The type ShippingRate.WeightUnit is not visible" error
        if (request.getWeightUnit() != null) {
            // Let the entity handle the conversion internally through reflection or other means
            try {
                // Using reflection to set the WeightUnit value
                Method method = ShippingRate.class.getMethod("setWeightUnit", String.class);
                method.invoke(shippingRate, request.getWeightUnit());
            } catch (Exception e) {
                throw new RuntimeException("Failed to set weight unit: " + e.getMessage(), e);
            }
        }
        
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