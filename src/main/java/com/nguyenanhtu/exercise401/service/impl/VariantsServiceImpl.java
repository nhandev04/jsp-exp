package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.repository.VariantsRepository;
import com.nguyenanhtu.exercise401.service.VariantsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VariantsServiceImpl implements VariantsService {

    private final VariantsRepository variantsRepository;

    @Override
    public List<Variants> getAllVariants() {
        return variantsRepository.findAll();
    }

    @Override
    public Optional<Variants> getVariantById(UUID id) {
        return variantsRepository.findById(id);
    }

    @Override
    public List<Variants> getVariantsByProductId(UUID productId) {
        return variantsRepository.findByProductId(productId);
    }

    @Override
    public List<Variants> getVariantsByVariantOptionId(UUID variantOptionId) {
        return variantsRepository.findByVariantOptionId(variantOptionId);
    }

    @Override
    public Variants addVariant(Variants variant) {
        return variantsRepository.save(variant);
    }

    @Override
    public Variants updateVariant(Variants variant) {
        return variantsRepository.save(variant);
    }

    @Override
    public void deleteVariant(UUID id) {
        variantsRepository.deleteById(id);
    }
}