package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ShippingZone;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShippingZoneService {
    List<ShippingZone> getAllShippingZones();
    
    Optional<ShippingZone> getShippingZoneById(UUID id);
    
    ShippingZone addShippingZone(ShippingZone shippingZone);
    
    ShippingZone updateShippingZone(ShippingZone shippingZone);
    
    void deleteShippingZone(UUID id);
}