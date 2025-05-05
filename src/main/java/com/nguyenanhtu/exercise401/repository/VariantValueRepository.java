package com.nguyenanhtu.exercise401.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nguyenanhtu.exercise401.entity.VariantValue;

@Repository
public interface VariantValueRepository extends JpaRepository<VariantValue, UUID> {

    @Query("SELECT vv FROM VariantValue vv WHERE vv.variant.id = :variantId")
    List<VariantValue> findByVariantId(@Param("variant") UUID variantId);

    @Query("SELECT vv FROM VariantValue vv WHERE vv.productAttributeValue.id = :productAttributeValueId")
    List<VariantValue> findByProductAttributeValueId(@Param("productAttributeValue") UUID productAttributeValueId);

    @Query("SELECT vv FROM VariantValue vv WHERE vv.variant.product.id = :productId")
    List<VariantValue> findByProductId(@Param("product") UUID productId);

    @Query("SELECT vv FROM VariantValue vv WHERE vv.productAttributeValue.attributeValue.attribute.id = :attributeId")
    List<VariantValue> findByAttributeId(@Param("attribute") UUID attributeId);

    @Query("SELECT vv FROM VariantValue vv WHERE vv.productAttributeValue.attributeValue.id = :attributeValueId")
    List<VariantValue> findByAttributeValueId(@Param("attributeValue") UUID attributeValueId);
}