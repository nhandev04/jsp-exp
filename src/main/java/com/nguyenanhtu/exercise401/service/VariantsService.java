package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Variants;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VariantsService {
    List<Variants> getAllVariants();
    
    Optional<Variants> getVariantById(UUID id);
    
    List<Variants> getVariantsByProductId(UUID productId);
    
    List<Variants> getVariantsByVariantOptionId(UUID variantOptionId);
    
    Variants addVariant(Variants variant);
    
    Variants updateVariant(Variants variant);
    
    void deleteVariant(UUID id);
}