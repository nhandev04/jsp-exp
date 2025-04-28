package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductAttributeRepository extends JpaRepository<ProductAttribute, UUID> {
    @Query("SELECT pa FROM ProductAttribute pa WHERE pa.product.id = :productId")
    List<ProductAttribute> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT pa FROM ProductAttribute pa WHERE pa.attribute.id = :attributeId")
    List<ProductAttribute> findByAttributeId(@Param("attributeId") UUID attributeId);
}
