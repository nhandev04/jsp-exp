package com.nguyenanhtu.exercise401.repository;

import com.nguyenanhtu.exercise401.entity.CardItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CardItemRepository extends JpaRepository<CardItem, UUID> {
    @Query("SELECT ci FROM CardItem ci WHERE ci.card.id = :cardId")
    List<CardItem> findByCardId(@Param("cardId") UUID cardId);
}
