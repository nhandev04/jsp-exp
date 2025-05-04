package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.SellsRequest;
import com.nguyenanhtu.exercise401.entity.Sells;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SellsService {
    List<Sells> getAllSells();
    
    Optional<Sells> getSellById(UUID id);
    
    List<Sells> getSellsByProductId(UUID productId);

    Sells addSell(SellsRequest request);
    
    Sells updateSell(UUID id, SellsRequest request);
    
    void deleteSell(UUID id);
}