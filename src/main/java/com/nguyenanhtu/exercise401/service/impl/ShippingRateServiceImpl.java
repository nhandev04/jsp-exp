package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ShippingRate;
import com.nguyenanhtu.exercise401.repository.ShippingRateRepository;
import com.nguyenanhtu.exercise401.service.ShippingRateService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ShippingRateServiceImpl implements ShippingRateService {

    private final ShippingRateRepository shippingRateRepository;

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
    public ShippingRate addShippingRate(ShippingRate shippingRate) {
        return shippingRateRepository.save(shippingRate);
    }

    @Override
    public ShippingRate updateShippingRate(ShippingRate shippingRate) {
        return shippingRateRepository.save(shippingRate);
    }

    @Override
    public void deleteShippingRate(UUID id) {
        shippingRateRepository.deleteById(id);
    }
}