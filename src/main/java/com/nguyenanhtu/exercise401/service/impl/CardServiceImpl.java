package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Card;
import com.nguyenanhtu.exercise401.repository.CardRepository;
import com.nguyenanhtu.exercise401.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> getCardById(UUID id) {
        return cardRepository.findById(id);
    }

    @Override
    public Card addCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public Card updateCard(Card card) {
        return cardRepository.save(card);
    }

    @Override
    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }
}