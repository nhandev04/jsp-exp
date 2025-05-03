package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.ProductShippingInfoRequest;
import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductShippingInfoService {
    List<ProductShippingInfo> getAllProductShippingInfos();
    
    Optional<ProductShippingInfo> getProductShippingInfoById(UUID id);
    
    Optional<ProductShippingInfo> getProductShippingInfoByProductId(UUID productId);

    ProductShippingInfo addProductShippingInfo(ProductShippingInfoRequest request);
    
    ProductShippingInfo updateProductShippingInfo(UUID id, ProductShippingInfoRequest request);
    
    void deleteProductShippingInfo(UUID id);
}