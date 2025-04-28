package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ShippingRate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShippingRateService {
    List<ShippingRate> getAllShippingRates();
    
    Optional<ShippingRate> getShippingRateById(UUID id);
    
    List<ShippingRate> getShippingRatesByShippingZoneId(UUID shippingZoneId);
    
    ShippingRate addShippingRate(ShippingRate shippingRate);
    
    ShippingRate updateShippingRate(ShippingRate shippingRate);
    
    void deleteShippingRate(UUID id);
}