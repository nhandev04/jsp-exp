package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.controller.request.VariantsRequest;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.VariantOption;
import com.nguyenanhtu.exercise401.repository.VariantsRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.VariantOptionRepository;
import com.nguyenanhtu.exercise401.service.VariantsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class VariantsServiceImpl implements VariantsService {

    private final VariantsRepository variantsRepository;
    private final ProductRepository productRepository;
    private final VariantOptionRepository variantOptionRepository;

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
    public Variants addVariant(VariantsRequest request) {
        Variants variant = new Variants();
        return saveVariant(variant, request);
    }

    @Override
    public Variants updateVariant(UUID id, VariantsRequest request) {
        Variants variant = variantsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Variant not found with id: " + id));

        return saveVariant(variant, request);
    }

    @Override
    public void deleteVariant(UUID id) {
        variantsRepository.deleteById(id);
    }

    private Variants saveVariant(Variants variant, VariantsRequest request) {
        // Set basic properties
        if (request.getSku() != null) {
            variant.setSku(request.getSku());
        }
        if (request.getBarcode() != null) {
            variant.setBarcode(request.getBarcode());
        }
        if (request.getImage() != null) {
            variant.setImage(request.getImage());
        }
        if (request.getPrice() != null) {
            variant.setPrice(request.getPrice());
        }
        if (request.getComparePrice() != null) {
            variant.setComparePrice(request.getComparePrice());
        }
        if (request.getCostPrice() != null) {
            variant.setCostPrice(request.getCostPrice());
        }
        if (request.getInventory() != null) {
            variant.setInventory(request.getInventory());
        }

        // Set variant option if provided
        if (request.getVariantOptionId() != null) {
            VariantOption variantOption = variantOptionRepository.findById(request.getVariantOptionId())
                    .orElseThrow(() -> new RuntimeException(
                            "Variant option not found with id: " + request.getVariantOptionId()));
            variant.setVariantOption(variantOption);
        }

        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            variant.setProduct(product);
        }

        // Save and return the variant
        return variantsRepository.save(variant);
    }
}