package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.CardItemRequest;
import com.nguyenanhtu.exercise401.entity.CardItem;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardItemService {
    List<CardItem> getAllCardItems();
    
    Optional<CardItem> getCardItemById(UUID id);
    
    List<CardItem> getCardItemsByCardId(UUID cardId);

    CardItem addCardItem(CardItemRequest request);
    
    CardItem updateCardItem(UUID id, CardItemRequest request);
    
    void deleteCardItem(UUID id);
}