package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.Sells;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface SellsRepository extends JpaRepository<Sells, UUID> {
    @Query("SELECT s FROM Sells s WHERE s.product.id = :productId")
    Optional<Sells> findByProductId(@Param("productId") UUID productId);
}
