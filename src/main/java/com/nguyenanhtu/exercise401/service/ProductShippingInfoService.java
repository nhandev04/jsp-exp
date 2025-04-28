package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductShippingInfoService {
    List<ProductShippingInfo> getAllProductShippingInfos();
    
    Optional<ProductShippingInfo> getProductShippingInfoById(UUID id);
    
    Optional<ProductShippingInfo> getProductShippingInfoByProductId(UUID productId);
    
    ProductShippingInfo addProductShippingInfo(ProductShippingInfo productShippingInfo);
    
    ProductShippingInfo updateProductShippingInfo(ProductShippingInfo productShippingInfo);
    
    void deleteProductShippingInfo(UUID id);
}