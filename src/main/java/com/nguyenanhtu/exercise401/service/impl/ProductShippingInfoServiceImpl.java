package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import com.nguyenanhtu.exercise401.repository.ProductShippingInfoRepository;
import com.nguyenanhtu.exercise401.service.ProductShippingInfoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductShippingInfoServiceImpl implements ProductShippingInfoService {

    private final ProductShippingInfoRepository productShippingInfoRepository;

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
    public ProductShippingInfo addProductShippingInfo(ProductShippingInfo productShippingInfo) {
        return productShippingInfoRepository.save(productShippingInfo);
    }

    @Override
    public ProductShippingInfo updateProductShippingInfo(ProductShippingInfo productShippingInfo) {
        return productShippingInfoRepository.save(productShippingInfo);
    }

    @Override
    public void deleteProductShippingInfo(UUID id) {
        productShippingInfoRepository.deleteById(id);
    }
}