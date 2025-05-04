package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.VariantsRequest;
import com.nguyenanhtu.exercise401.entity.Variants;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VariantsService {
    List<Variants> getAllVariants();
    
    Optional<Variants> getVariantById(UUID id);
    
    List<Variants> getVariantsByProductId(UUID productId);

    Variants addVariant(VariantsRequest request);
    
    Variants updateVariant(UUID id, VariantsRequest request);
    
    void deleteVariant(UUID id);
}