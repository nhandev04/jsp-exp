package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.ShippingZoneRequest;
import com.nguyenanhtu.exercise401.entity.ShippingZone;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.ShippingZoneRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.ShippingZoneService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShippingZoneServiceImpl implements ShippingZoneService {

    private final ShippingZoneRepository shippingZoneRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<ShippingZone> getAllShippingZones() {
        return shippingZoneRepository.findAll();
    }

    @Override
    public Optional<ShippingZone> getShippingZoneById(UUID id) {
        return shippingZoneRepository.findById(id);
    }

    @Override
    public ShippingZone addShippingZone(ShippingZoneRequest request) {
        ShippingZone shippingZone = new ShippingZone();
        return saveShippingZone(shippingZone, request);
    }

    @Override
    public ShippingZone updateShippingZone(UUID id, ShippingZoneRequest request) {
        ShippingZone shippingZone = shippingZoneRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Shipping zone not found with id: " + id));
        
        return saveShippingZone(shippingZone, request);
    }

    @Override
    public void deleteShippingZone(UUID id) {
        shippingZoneRepository.deleteById(id);
    }
    
    private ShippingZone saveShippingZone(ShippingZone shippingZone, ShippingZoneRequest request) {
        // Set basic properties
        shippingZone.setName(request.getName());
        shippingZone.setDisplayName(request.getDisplayName());
        shippingZone.setActive(request.getActive());
        shippingZone.setFreeShipping(request.getFreeShipping());
        shippingZone.setRateType(request.getRateType());
        
        // Set createdBy if provided and this is a new shipping zone
        if (request.getCreatedBy() != null && shippingZone.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            shippingZone.setCreatedBy(createdByAccount);
        }
        
        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            shippingZone.setUpdatedBy(updatedByAccount);
        }
        
        // Save and return the shipping zone
        return shippingZoneRepository.save(shippingZone);
    }
}