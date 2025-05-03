package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.ShippingRateRequest;
import com.nguyenanhtu.exercise401.entity.ShippingRate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShippingRateService {
    List<ShippingRate> getAllShippingRates();
    
    Optional<ShippingRate> getShippingRateById(UUID id);
    
    List<ShippingRate> getShippingRatesByShippingZoneId(UUID shippingZoneId);

    ShippingRate addShippingRate(ShippingRateRequest request);
    
    ShippingRate updateShippingRate(UUID id, ShippingRateRequest request);
    
    void deleteShippingRate(UUID id);
}