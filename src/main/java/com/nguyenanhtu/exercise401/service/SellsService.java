package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.entity.Sells;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SellsService {
    List<Sells> getAllSells();
    
    Optional<Sells> getSellsById(UUID id);
    
    Optional<Sells> getSellsByProductId(UUID productId);
    
    Sells addSells(Sells sells);
    
    Sells updateSells(Sells sells);
    
    void deleteSells(UUID id);
}