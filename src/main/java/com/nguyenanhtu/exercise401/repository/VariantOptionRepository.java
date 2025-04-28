package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.VariantOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VariantOptionRepository extends JpaRepository<VariantOption, UUID> {
    @Query("SELECT vo FROM VariantOption vo WHERE vo.product.id = :productId")
    List<VariantOption> findByProductId(@Param("productId") UUID productId);
}
