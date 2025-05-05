package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.VariantOptionRequest;
import com.nguyenanhtu.exercise401.entity.Gallery;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.VariantOption;
import com.nguyenanhtu.exercise401.entity.Variants;
import com.nguyenanhtu.exercise401.repository.GalleryRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
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
    private final GalleryRepository galleryRepository;
    private final ProductRepository productRepository;

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
        if (request.getTitle() != null) {
            variantOption.setTitle(request.getTitle());
        }
        if (request.getSalePrice() != null) {
            variantOption.setSalePrice(request.getSalePrice());
        }
        if (request.getComparePrice() != null) {
            variantOption.setComparePrice(request.getComparePrice());
        }
        if (request.getBuyingPrice() != null) {
            variantOption.setBuyingPrice(request.getBuyingPrice());
        }
        if (request.getQuantity() != null) {
            variantOption.setQuantity(request.getQuantity());
        }
        if (request.getSku() != null) {
            variantOption.setSku(request.getSku());
        }
        if (request.getActive() != null) {
            variantOption.setActive(request.getActive());
        }

        if (request.getImageId() != null) {
            Gallery image = galleryRepository.findById(request.getImageId())
                    .orElseThrow(() -> new RuntimeException("Image not found with id: " + request.getImageId()));
            variantOption.setImage(image);
        }

        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            variantOption.setProduct(product);
        }

        if (request.getVariantId() != null) {
            Variants variant = variantsRepository.findById(request.getVariantId())
                    .orElseThrow(() -> new RuntimeException("Variant not found with id: " + request.getVariantId()));
            variantOption.setVariant(variant);
        }

        return variantOptionRepository.save(variantOption);
    }

}