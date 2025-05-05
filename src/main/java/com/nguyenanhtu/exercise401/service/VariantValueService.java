package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.VariantValueRequest;
import com.nguyenanhtu.exercise401.entity.VariantValue;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VariantValueService {
    List<VariantValue> getAllVariantValues();

    Optional<VariantValue> getVariantValueById(UUID id);

    List<VariantValue> getVariantValuesByVariantId(UUID variantId);

    List<VariantValue> getVariantValuesByProductId(UUID productId);

    List<VariantValue> getVariantValuesByProductAttributeValueId(UUID productAttributeValueId);

    List<VariantValue> getVariantValuesByAttributeId(UUID attributeId);

    List<VariantValue> getVariantValuesByAttributeValueId(UUID attributeValueId);

    VariantValue addVariantValue(VariantValueRequest request);

    VariantValue updateVariantValue(UUID id, VariantValueRequest request);

    void deleteVariantValue(UUID id);
}