package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.VariantsRequest;
import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.repository.VariantsRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
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
        variant.setSku(request.getSku());
        variant.setBarcode(request.getBarcode());
        variant.setImage(request.getImage());
        variant.setPrice(request.getPrice());
        variant.setComparePrice(request.getComparePrice());
        variant.setCostPrice(request.getCostPrice());
        variant.setInventory(request.getInventory());
        
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