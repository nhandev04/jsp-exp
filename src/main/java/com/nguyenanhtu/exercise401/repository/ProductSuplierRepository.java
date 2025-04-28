package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductSuplier;
import com.nguyenanhtu.exercise401.entity.ProductSuplier.ProductSuplierId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductSuplierRepository extends JpaRepository<ProductSuplier, ProductSuplierId> {
    @Query("SELECT ps FROM ProductSuplier ps WHERE ps.id.productId = :productId")
    List<ProductSuplier> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT ps FROM ProductSuplier ps WHERE ps.id.supplierId = :supplierId")
    List<ProductSuplier> findBySupplierId(@Param("supplierId") UUID supplierId);
}
