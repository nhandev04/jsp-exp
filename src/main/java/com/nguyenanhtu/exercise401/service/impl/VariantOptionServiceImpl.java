package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.VariantOption;
import com.nguyenanhtu.exercise401.repository.VariantOptionRepository;
import com.nguyenanhtu.exercise401.service.VariantOptionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VariantOptionServiceImpl implements VariantOptionService {

    private final VariantOptionRepository variantOptionRepository;

    @Override
    public List<VariantOption> getAllVariantOptions() {
        return variantOptionRepository.findAll();
    }

    @Override
    public Optional<VariantOption> getVariantOptionById(UUID id) {
        return variantOptionRepository.findById(id);
    }

    @Override
    public List<VariantOption> getVariantOptionsByProductId(UUID productId) {
        return variantOptionRepository.findByProductId(productId);
    }

    @Override
    public VariantOption addVariantOption(VariantOption variantOption) {
        return variantOptionRepository.save(variantOption);
    }

    @Override
    public VariantOption updateVariantOption(VariantOption variantOption) {
        return variantOptionRepository.save(variantOption);
    }

    @Override
    public void deleteVariantOption(UUID id) {
        variantOptionRepository.deleteById(id);
    }
}