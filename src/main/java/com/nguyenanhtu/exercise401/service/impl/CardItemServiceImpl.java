package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.CardItem;
import com.nguyenanhtu.exercise401.repository.CardItemRepository;
import com.nguyenanhtu.exercise401.service.CardItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardItemServiceImpl implements CardItemService {

    private final CardItemRepository cardItemRepository;

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
    public CardItem addCardItem(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public CardItem updateCardItem(CardItem cardItem) {
        return cardItemRepository.save(cardItem);
    }

    @Override
    public void deleteCardItem(UUID id) {
        cardItemRepository.deleteById(id);
    }
}