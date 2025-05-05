package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import com.nguyenanhtu.exercise401.controller.request.ProductShippingInfoRequest;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.repository.ProductShippingInfoRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.service.ProductShippingInfoService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductShippingInfoServiceImpl implements ProductShippingInfoService {

    private final ProductShippingInfoRepository productShippingInfoRepository;
    private final ProductRepository productRepository;

    @Override
    public List<ProductShippingInfo> getAllProductShippingInfos() {
        return productShippingInfoRepository.findAll();
    }

    @Override
    public Optional<ProductShippingInfo> getProductShippingInfoById(UUID id) {
        return productShippingInfoRepository.findById(id);
    }

    @Override
    public Optional<ProductShippingInfo> getProductShippingInfoByProductId(UUID productId) {
        return productShippingInfoRepository.findByProductId(productId);
    }

    @Override
    public ProductShippingInfo addProductShippingInfo(ProductShippingInfoRequest request) {
        ProductShippingInfo productShippingInfo = new ProductShippingInfo();
        return saveProductShippingInfo(productShippingInfo, request);
    }

    @Override
    public ProductShippingInfo updateProductShippingInfo(UUID id, ProductShippingInfoRequest request) {
        ProductShippingInfo productShippingInfo = productShippingInfoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product shipping info not found with id: " + id));

        return saveProductShippingInfo(productShippingInfo, request);
    }

    @Override
    public void deleteProductShippingInfo(UUID id) {
        productShippingInfoRepository.deleteById(id);
    }

    private ProductShippingInfo saveProductShippingInfo(ProductShippingInfo productShippingInfo,
            ProductShippingInfoRequest request) {
        // Set basic properties
        if (request.getWeight() != null) {
            productShippingInfo.setWeight(request.getWeight());
        }
        if (request.getWeightUnit() != null) {
            productShippingInfo.setWeightUnit(ProductShippingInfo.WeightUnit.valueOf(request.getWeightUnit()));
        }
        if (request.getVolume() != null) {
            productShippingInfo.setVolume(request.getVolume());
        }
        if (request.getVolumeUnit() != null) {
            productShippingInfo.setVolumeUnit(ProductShippingInfo.VolumeUnit.valueOf(request.getVolumeUnit()));
        }
        if (request.getDimensionWidth() != null) {
            productShippingInfo.setDimensionWidth(request.getDimensionWidth());
        }
        if (request.getDimensionHeight() != null) {
            productShippingInfo.setDimensionHeight(request.getDimensionHeight());
        }
        if (request.getDimensionDepth() != null) {
            productShippingInfo.setDimensionDepth(request.getDimensionDepth());
        }
        if (request.getDimensionUnit() != null) {
            productShippingInfo.setDimensionUnit(ProductShippingInfo.DimensionUnit.valueOf(request.getDimensionUnit()));
        }

        // Set product if provided
        if (request.getProduct() != null) {
            Product product = productRepository.findById(request.getProduct())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProduct()));
            productShippingInfo.setProduct(product);
        }

        // Save and return the product shipping info
        return productShippingInfoRepository.save(productShippingInfo);
    }
}