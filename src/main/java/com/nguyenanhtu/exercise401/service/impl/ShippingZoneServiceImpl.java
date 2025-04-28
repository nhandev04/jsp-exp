package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ShippingZone;
import com.nguyenanhtu.exercise401.repository.ShippingZoneRepository;
import com.nguyenanhtu.exercise401.service.ShippingZoneService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShippingZoneServiceImpl implements ShippingZoneService {

    private final ShippingZoneRepository shippingZoneRepository;

    @Override
    public List<ShippingZone> getAllShippingZones() {
        return shippingZoneRepository.findAll();
    }

    @Override
    public Optional<ShippingZone> getShippingZoneById(UUID id) {
        return shippingZoneRepository.findById(id);
    }

    @Override
    public ShippingZone addShippingZone(ShippingZone shippingZone) {
        return shippingZoneRepository.save(shippingZone);
    }

    @Override
    public ShippingZone updateShippingZone(ShippingZone shippingZone) {
        return shippingZoneRepository.save(shippingZone);
    }

    @Override
    public void deleteShippingZone(UUID id) {
        shippingZoneRepository.deleteById(id);
    }
}