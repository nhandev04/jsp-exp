package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductAttributeValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductAttributeValueRepository extends JpaRepository<ProductAttributeValue, UUID> {
    @Query("SELECT pav FROM ProductAttributeValue pav WHERE pav.productAttribute.id = :productAttributeId")
    List<ProductAttributeValue> findByProductAttributeId(@Param("productAttributeId") UUID productAttributeId);

    @Query("SELECT pav FROM ProductAttributeValue pav WHERE pav.attributeValue.id = :attributeValueId")
    List<ProductAttributeValue> findByAttributeValueId(@Param("attributeValueId") UUID attributeValueId);

    @Query("SELECT pav FROM ProductAttributeValue pav WHERE pav.productAttribute.product.id = :productId")
    List<ProductAttributeValue> findByProductId(@Param("productId") UUID productId);
}
