package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Variants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VariantsRepository extends JpaRepository<Variants, UUID> {
    @Query("SELECT v FROM Variants v WHERE v.product.id = :productId")
    List<Variants> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT v FROM Variants v WHERE v.variantOption.id = :variantOptionId")
    List<Variants> findByVariantOptionId(@Param("variantOptionId") UUID variantOptionId);
}
