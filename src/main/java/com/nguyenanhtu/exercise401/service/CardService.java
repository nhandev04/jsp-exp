package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.CardRequest;
import com.nguyenanhtu.exercise401.entity.Card;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CardService {
    List<Card> getAllCards();
    
    Optional<Card> getCardById(UUID id);

    Card addCard(CardRequest request);
    
    Card updateCard(UUID id, CardRequest request);
    
    void deleteCard(UUID id);
}