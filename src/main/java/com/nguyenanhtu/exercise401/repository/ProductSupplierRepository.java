package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.ProductSupplier;
import com.nguyenanhtu.exercise401.entity.ProductSupplier.ProductSupplierId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, ProductSupplierId> {
    @Query("SELECT ps FROM ProductSupplier ps WHERE ps.id.productId = :productId")
    List<ProductSupplier> findByProductId(@Param("productId") UUID productId);

    @Query("SELECT ps FROM ProductSupplier ps WHERE ps.id.supplierId = :supplierId")
    List<ProductSupplier> findBySupplierId(@Param("supplierId") UUID supplierId);

    @Query("SELECT ps FROM ProductSupplier ps WHERE ps.id.productId = :productId AND ps.isPrimary = true")
    List<ProductSupplier> findPrimarySuppliersByProductId(@Param("productId") UUID productId);
}