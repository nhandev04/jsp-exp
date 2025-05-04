package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.VariantOptionRequest;
import com.nguyenanhtu.exercise401.entity.VariantOption;
import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.repository.VariantOptionRepository;
import com.nguyenanhtu.exercise401.repository.VariantsRepository;
import com.nguyenanhtu.exercise401.service.VariantOptionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VariantOptionServiceImpl implements VariantOptionService {

    private final VariantOptionRepository variantOptionRepository;
    private final VariantsRepository variantsRepository;

    @Override
    public List<VariantOption> getAllVariantOptions() {
        return variantOptionRepository.findAll();
    }

    @Override
    public Optional<VariantOption> getVariantOptionById(UUID id) {
        return variantOptionRepository.findById(id);
    }
    
    @Override
    public List<VariantOption> getVariantOptionsByVariantId(UUID variantId) {
        return variantOptionRepository.findByVariantId(variantId);
    }

    @Override
    public List<VariantOption> getVariantOptionsByProductId(UUID productId) {
        return variantOptionRepository.findByProductId(productId);
    }

    @Override
    public VariantOption addVariantOption(VariantOptionRequest request) {
        VariantOption variantOption = new VariantOption();
        return saveVariantOption(variantOption, request);
    }

    @Override
    public VariantOption updateVariantOption(UUID id, VariantOptionRequest request) {
        VariantOption variantOption = variantOptionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant option not found with id: " + id));
        
        return saveVariantOption(variantOption, request);
    }

    @Override
    public void deleteVariantOption(UUID id) {
        variantOptionRepository.deleteById(id);
    }
    
    private VariantOption saveVariantOption(VariantOption variantOption, VariantOptionRequest request) {
        // Set basic properties
        variantOption.setOptionName(request.getVariantOptionName());
        variantOption.setOptionValue(request.getVariantOptionValue());
        
        // Set variant if provided
        if (request.getVariantOptionId() != null) {
            Variants variant = variantsRepository.findById(request.getVariantOptionId())
                    .orElseThrow(() -> new RuntimeException("Variant not found with id: " + request.getVariantOptionId()));
            variantOption.setVariant(variant);
        }
        
        // Save and return the variant option
        return variantOptionRepository.save(variantOption);
    }
}