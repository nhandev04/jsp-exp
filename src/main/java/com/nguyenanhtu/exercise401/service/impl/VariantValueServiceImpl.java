package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.VariantValueRequest;
import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.entity.VariantValue;
import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.repository.ProductAttributeValueRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.repository.VariantValueRepository;
import com.nguyenanhtu.exercise401.repository.VariantsRepository;
import com.nguyenanhtu.exercise401.service.VariantValueService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VariantValueServiceImpl implements VariantValueService {

    private final VariantValueRepository variantValueRepository;
    private final VariantsRepository variantsRepository;
    private final ProductAttributeValueRepository productAttributeValueRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<VariantValue> getAllVariantValues() {
        return variantValueRepository.findAll();
    }

    @Override
    public Optional<VariantValue> getVariantValueById(UUID id) {
        return variantValueRepository.findById(id);
    }

    @Override
    public List<VariantValue> getVariantValuesByVariantId(UUID variantId) {
        return variantValueRepository.findByVariantId(variantId);
    }

    @Override
    public List<VariantValue> getVariantValuesByProductId(UUID productId) {
        return variantValueRepository.findByProductId(productId);
    }

    @Override
    public List<VariantValue> getVariantValuesByProductAttributeValueId(UUID productAttributeValueId) {
        return variantValueRepository.findByProductAttributeValueId(productAttributeValueId);
    }

    @Override
    public List<VariantValue> getVariantValuesByAttributeId(UUID attributeId) {
        return variantValueRepository.findByAttributeId(attributeId);
    }

    @Override
    public List<VariantValue> getVariantValuesByAttributeValueId(UUID attributeValueId) {
        return variantValueRepository.findByAttributeValueId(attributeValueId);
    }

    @Override
    public VariantValue addVariantValue(VariantValueRequest request) {
        VariantValue variantValue = new VariantValue();
        return saveVariantValue(variantValue, request);
    }

    @Override
    public VariantValue updateVariantValue(UUID id, VariantValueRequest request) {
        VariantValue variantValue = variantValueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant value not found with id: " + id));

        return saveVariantValue(variantValue, request);
    }

    @Override
    public void deleteVariantValue(UUID id) {
        variantValueRepository.deleteById(id);
    }

    private VariantValue saveVariantValue(VariantValue variantValue, VariantValueRequest request) {
        // Set variant if provided
        if (request.getVariant() != null) {
            Variants variant = variantsRepository.findById(request.getVariant())
                    .orElseThrow(() -> new RuntimeException("Variant not found with id: " + request.getVariant()));
            variantValue.setVariant(variant);
        }

        // Set product attribute value if provided
        if (request.getProductAttributeValue() != null) {
            ProductAttributeValue productAttributeValue = productAttributeValueRepository
                    .findById(request.getProductAttributeValue())
                    .orElseThrow(() -> new RuntimeException(
                            "Product attribute value not found with id: " + request.getProductAttributeValue()));
            variantValue.setProductAttributeValue(productAttributeValue);
        }

        // Set created by if provided
        if (request.getCreatedBy() != null) {
            StaffAccount createdBy = staffAccountRepository.findById(request.getCreatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getCreatedBy()));
            variantValue.setCreatedBy(createdBy);
        }

        // Set updated by if provided
        if (request.getUpdatedBy() != null) {
            StaffAccount updatedBy = staffAccountRepository.findById(request.getUpdatedBy())
                    .orElseThrow(
                            () -> new RuntimeException("Staff account not found with id: " + request.getUpdatedBy()));
            variantValue.setUpdatedBy(updatedBy);
        }

        // Save and return the variant value
        return variantValueRepository.save(variantValue);
    }
}