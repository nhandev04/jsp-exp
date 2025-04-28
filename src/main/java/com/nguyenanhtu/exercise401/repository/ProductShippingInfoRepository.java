package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductShippingInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductShippingInfoRepository extends JpaRepository<ProductShippingInfo, UUID> {
    @Query("SELECT psi FROM ProductShippingInfo psi WHERE psi.product.id = :productId")
    Optional<ProductShippingInfo> findByProductId(@Param("productId") UUID productId);
}
