package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.CardRequest;
import com.nguyenanhtu.exercise401.entity.Card;
import com.nguyenanhtu.exercise401.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardService cardService;

    @GetMapping
    public ResponseEntity<List<Card>> getAllCards() {
        List<Card> cards = cardService.getAllCards();
        return ResponseEntity.ok(cards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Card> getCardById(@PathVariable UUID id) {
        return cardService.getCardById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Card> addCard(@RequestBody CardRequest cardRequest) {
        Card createdCard = cardService.addCard(cardRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCard);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Card> updateCard(@PathVariable UUID id, @RequestBody CardRequest cardRequest) {
        try {
            Card updatedCard = cardService.updateCard(id, cardRequest);
            return ResponseEntity.ok(updatedCard);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCard(@PathVariable UUID id) {
        cardService.deleteCard(id);
        return ResponseEntity.noContent().build();
    }
}