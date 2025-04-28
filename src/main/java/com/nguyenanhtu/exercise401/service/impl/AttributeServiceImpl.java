package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Attribute;
import com.nguyenanhtu.exercise401.repository.AttributeRepository;
import com.nguyenanhtu.exercise401.service.AttributeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Optional<Attribute> getAttributeById(UUID id) {
        return attributeRepository.findById(id);
    }

    @Override
    public Attribute addAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public Attribute updateAttribute(Attribute attribute) {
        return attributeRepository.save(attribute);
    }

    @Override
    public void deleteAttribute(UUID id) {
        attributeRepository.deleteById(id);
    }
}