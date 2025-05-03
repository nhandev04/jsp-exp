package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.CardItemRequest;
import com.nguyenanhtu.exercise401.entity.CardItem;
import com.nguyenanhtu.exercise401.entity.Card;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.repository.CardItemRepository;
import com.nguyenanhtu.exercise401.repository.CardRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.service.CardItemService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardItemServiceImpl implements CardItemService {

    private final CardItemRepository cardItemRepository;
    private final CardRepository cardRepository;
    private final ProductRepository productRepository;

    @Override
    public List<CardItem> getAllCardItems() {
        return cardItemRepository.findAll();
    }

    @Override
    public Optional<CardItem> getCardItemById(UUID id) {
        return cardItemRepository.findById(id);
    }
    
    @Override
    public List<CardItem> getCardItemsByCardId(UUID cardId) {
        return cardItemRepository.findByCardId(cardId);
    }

    @Override
    public CardItem addCardItem(CardItemRequest request) {
        CardItem cardItem = new CardItem();
        return saveCardItem(cardItem, request);
    }

    @Override
    public CardItem updateCardItem(UUID id, CardItemRequest request) {
        CardItem cardItem = cardItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card item not found with id: " + id));
        
        return saveCardItem(cardItem, request);
    }

    @Override
    public void deleteCardItem(UUID id) {
        cardItemRepository.deleteById(id);
    }
    
    private CardItem saveCardItem(CardItem cardItem, CardItemRequest request) {
        // Set basic properties
        cardItem.setQuantity(request.getQuantity());
        
        // Set card if provided
        if (request.getCardId() != null) {
            Card card = cardRepository.findById(request.getCardId())
                    .orElseThrow(() -> new RuntimeException("Card not found with id: " + request.getCardId()));
            cardItem.setCard(card);
        }
        
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            cardItem.setProduct(product);
        }
        
        // Save and return the card item
        return cardItemRepository.save(cardItem);
    }
}