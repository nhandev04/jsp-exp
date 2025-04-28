package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.VariantOption;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VariantOptionService {
    List<VariantOption> getAllVariantOptions();
    
    Optional<VariantOption> getVariantOptionById(UUID id);
    
    List<VariantOption> getVariantOptionsByProductId(UUID productId);
    
    VariantOption addVariantOption(VariantOption variantOption);
    
    VariantOption updateVariantOption(VariantOption variantOption);
    
    void deleteVariantOption(UUID id);
}