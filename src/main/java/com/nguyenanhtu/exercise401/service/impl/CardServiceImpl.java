package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.CardRequest;
import com.nguyenanhtu.exercise401.entity.Card;
import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.repository.CardRepository;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import com.nguyenanhtu.exercise401.service.CardService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CustomerRepository customerRepository;

    @Override
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @Override
    public Optional<Card> getCardById(UUID id) {
        return cardRepository.findById(id);
    }

    @Override
    public Card addCard(CardRequest request) {
        Card card = new Card();
        return saveCard(card, request);
    }

    @Override
    public Card updateCard(UUID id, CardRequest request) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Card not found with id: " + id));
        
        return saveCard(card, request);
    }

    @Override
    public void deleteCard(UUID id) {
        cardRepository.deleteById(id);
    }
    
    private Card saveCard(Card card, CardRequest request) {
        // Set customer if provided
        if (request.getCustomerId() != null) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomerId()));
            card.setCustomer(customer);
        }
        
        // Save and return the card
        return cardRepository.save(card);
    }
}