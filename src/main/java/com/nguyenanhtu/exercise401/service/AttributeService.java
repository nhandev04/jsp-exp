package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.AttributeRequest;
import com.nguyenanhtu.exercise401.entity.Attribute;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttributeService {
    List<Attribute> getAllAttributes();
    
    Optional<Attribute> getAttributeById(UUID id);

    Attribute addAttribute(AttributeRequest request);
    
    Attribute updateAttribute(UUID id, AttributeRequest request);
    
    void deleteAttribute(UUID id);
}