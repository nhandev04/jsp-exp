package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.entity.CardItem;
import com.nguyenanhtu.exercise401.service.CardItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/card-items")
public class CardItemController {

    @Autowired
    private CardItemService cardItemService;

    @GetMapping
    public ResponseEntity<List<CardItem>> getAllCardItems() {
        List<CardItem> cardItems = cardItemService.getAllCardItems();
        return ResponseEntity.ok(cardItems);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardItem> getCardItemById(@PathVariable UUID id) {
        return cardItemService.getCardItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/card/{cardId}")
    public ResponseEntity<List<CardItem>> getCardItemsByCardId(@PathVariable UUID cardId) {
        List<CardItem> cardItems = cardItemService.getCardItemsByCardId(cardId);
        return ResponseEntity.ok(cardItems);
    }

    @PostMapping
    public ResponseEntity<CardItem> addCardItem(@RequestBody CardItem cardItem) {
        CardItem createdCardItem = cardItemService.addCardItem(cardItem);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCardItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CardItem> updateCardItem(@PathVariable UUID id, @RequestBody CardItem cardItem) {
        cardItem.setId(id);
        CardItem updatedCardItem = cardItemService.updateCardItem(cardItem);
        return ResponseEntity.ok(updatedCardItem);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardItem(@PathVariable UUID id) {
        cardItemService.deleteCardItem(id);
        return ResponseEntity.noContent().build();
    }
}