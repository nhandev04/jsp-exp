package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.VariantOptionRequest;
import com.nguyenanhtu.exercise401.entity.VariantOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VariantOptionService {
    List<VariantOption> getAllVariantOptions();
    
    Optional<VariantOption> getVariantOptionById(UUID id);
    
    List<VariantOption> getVariantOptionsByVariantId(UUID variantId);

    List<VariantOption> getVariantOptionsByProductId(UUID productId);

    VariantOption addVariantOption(VariantOptionRequest request);
    
    VariantOption updateVariantOption(UUID id, VariantOptionRequest request);
    
    void deleteVariantOption(UUID id);
}