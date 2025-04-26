package com.nguyenanhtu.exercise401.service;

import java.util.List;
import java.util.UUID;
import com.nguyenanhtu.exercise401.entity.VariantValue;

public interface VariantValueService {
    VariantValue createVariantValue(VariantValue variantValue);

    VariantValue getVariantValueById(UUID id);

    List<VariantValue> getAllVariantValues();

    VariantValue updateVariantValue(VariantValue variantValue);

    void deleteVariantValue(UUID id);
}