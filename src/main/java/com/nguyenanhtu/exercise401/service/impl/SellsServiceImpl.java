package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.Sells;
import com.nguyenanhtu.exercise401.repository.SellsRepository;
import com.nguyenanhtu.exercise401.service.SellsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class SellsServiceImpl implements SellsService {

    private final SellsRepository sellsRepository;

    @Override
    public List<Sells> getAllSells() {
        return sellsRepository.findAll();
    }

    @Override
    public Optional<Sells> getSellsById(UUID id) {
        return sellsRepository.findById(id);
    }

    @Override
    public Optional<Sells> getSellsByProductId(UUID productId) {
        return sellsRepository.findByProductId(productId);
    }

    @Override
    public Sells addSells(Sells sells) {
        return sellsRepository.save(sells);
    }

    @Override
    public Sells updateSells(Sells sells) {
        return sellsRepository.save(sells);
    }

    @Override
    public void deleteSells(UUID id) {
        sellsRepository.deleteById(id);
    }
}