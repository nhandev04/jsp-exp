package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.ShippingZoneRequest;
import com.nguyenanhtu.exercise401.entity.ShippingZone;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ShippingZoneService {
    List<ShippingZone> getAllShippingZones();
    
    Optional<ShippingZone> getShippingZoneById(UUID id);

    ShippingZone addShippingZone(ShippingZoneRequest request);
    
    ShippingZone updateShippingZone(UUID id, ShippingZoneRequest request);
    
    void deleteShippingZone(UUID id);
}