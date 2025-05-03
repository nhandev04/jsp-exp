package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.AttributeValueRequest;
import com.nguyenanhtu.exercise401.entity.AttributeValue;
import com.nguyenanhtu.exercise401.entity.Attribute;
import com.nguyenanhtu.exercise401.repository.AttributeValueRepository;
import com.nguyenanhtu.exercise401.repository.AttributeRepository;
import com.nguyenanhtu.exercise401.service.AttributeValueService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;
    private final AttributeRepository attributeRepository;

    @Override
    public List<AttributeValue> getAllAttributeValues() {
        return attributeValueRepository.findAll();
    }

    @Override
    public Optional<AttributeValue> getAttributeValueById(UUID id) {
        return attributeValueRepository.findById(id);
    }
    
    @Override
    public List<AttributeValue> getAttributeValuesByAttributeId(UUID attributeId) {
        return attributeValueRepository.findByAttributeId(attributeId);
    }

    @Override
    public AttributeValue addAttributeValue(AttributeValueRequest request) {
        AttributeValue attributeValue = new AttributeValue();
        return saveAttributeValue(attributeValue, request);
    }

    @Override
    public AttributeValue updateAttributeValue(UUID id, AttributeValueRequest request) {
        AttributeValue attributeValue = attributeValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute value not found with id: " + id));
        
        return saveAttributeValue(attributeValue, request);
    }

    @Override
    public void deleteAttributeValue(UUID id) {
        attributeValueRepository.deleteById(id);
    }
    
    private AttributeValue saveAttributeValue(AttributeValue attributeValue, AttributeValueRequest request) {
        // Set basic properties
        attributeValue.setAttributeValue(request.getAttributeValue());
        attributeValue.setColor(request.getColor());
        
        // Set attribute if provided
        if (request.getAttributeId() != null) {
            Attribute attribute = attributeRepository.findById(request.getAttributeId())
                    .orElseThrow(() -> new RuntimeException("Attribute not found with id: " + request.getAttributeId()));
            attributeValue.setAttribute(attribute);
        }
        
        // Save and return the attribute value
        return attributeValueRepository.save(attributeValue);
    }
}