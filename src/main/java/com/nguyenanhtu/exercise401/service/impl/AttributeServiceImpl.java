package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.AttributeRequest;
import com.nguyenanhtu.exercise401.entity.Attribute;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.AttributeRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.AttributeService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AttributeServiceImpl implements AttributeService {

    private final AttributeRepository attributeRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    @Override
    public Optional<Attribute> getAttributeById(UUID id) {
        return attributeRepository.findById(id);
    }

    @Override
    public Attribute addAttribute(AttributeRequest request) {
        Attribute attribute = new Attribute();
        return saveAttribute(attribute, request);
    }

    @Override
    public Attribute updateAttribute(UUID id, AttributeRequest request) {
        Attribute attribute = attributeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attribute not found with id: " + id));

        return saveAttribute(attribute, request);
    }

    @Override
    public void deleteAttribute(UUID id) {
        attributeRepository.deleteById(id);
    }

    private Attribute saveAttribute(Attribute attribute, AttributeRequest request) {
        // Set basic properties
        attribute.setAttributeName(request.getAttributeName());

        // Set createdBy if provided and this is a new attribute
        if (request.getCreatedBy() != null && attribute.getId() == null) {
            StaffAccount createdByAccount = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            attribute.setCreatedBy(createdByAccount);
        }

        // Set updatedBy if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedByAccount = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            attribute.setUpdatedBy(updatedByAccount);
        }

        // Save and return the attribute
        return attributeRepository.save(attribute);
    }
}