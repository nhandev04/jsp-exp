package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.AttributeValueRequest;
import com.nguyenanhtu.exercise401.entity.AttributeValue;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AttributeValueService {
    List<AttributeValue> getAllAttributeValues();
    
    Optional<AttributeValue> getAttributeValueById(UUID id);
    
    List<AttributeValue> getAttributeValuesByAttributeId(UUID attributeId);

    AttributeValue addAttributeValue(AttributeValueRequest request);
    
    AttributeValue updateAttributeValue(UUID id, AttributeValueRequest request);
    
    void deleteAttributeValue(UUID id);
}