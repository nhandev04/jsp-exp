package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.AttributeValue;
import com.nguyenanhtu.exercise401.repository.AttributeValueRepository;
import com.nguyenanhtu.exercise401.service.AttributeValueService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AttributeValueServiceImpl implements AttributeValueService {

    private final AttributeValueRepository attributeValueRepository;

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
    public AttributeValue addAttributeValue(AttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public AttributeValue updateAttributeValue(AttributeValue attributeValue) {
        return attributeValueRepository.save(attributeValue);
    }

    @Override
    public void deleteAttributeValue(UUID id) {
        attributeValueRepository.deleteById(id);
    }
}