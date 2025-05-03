package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.SellsRequest;
import com.nguyenanhtu.exercise401.entity.Sells;
import com.nguyenanhtu.exercise401.entity.Product;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.SellsRepository;
import com.nguyenanhtu.exercise401.repository.ProductRepository;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
import com.nguyenanhtu.exercise401.service.SellsService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SellsServiceImpl implements SellsService {

    private final SellsRepository sellsRepository;
    private final ProductRepository productRepository;
    private final StaffAccountRepository staffAccountRepository;

    @Override
    public List<Sells> getAllSells() {
        return sellsRepository.findAll();
    }

    @Override
    public Optional<Sells> getSellById(UUID id) {
        return sellsRepository.findById(id);
    }
    
    @Override
    public List<Sells> getSellsByProductId(UUID productId) {
        return sellsRepository.findByProductId(productId);
    }

    @Override
    public Sells addSell(SellsRequest request) {
        Sells sell = new Sells();
        return saveSell(sell, request);
    }

    @Override
    public Sells updateSell(UUID id, SellsRequest request) {
        Sells sell = sellsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sell not found with id: " + id));
        
        return saveSell(sell, request);
    }

    @Override
    public void deleteSell(UUID id) {
        sellsRepository.deleteById(id);
    }
    
    private Sells saveSell(Sells sell, SellsRequest request) {
        // Set basic properties
        sell.setQuantity(request.getQuantity());
        sell.setPrice(request.getPrice());
        sell.setDateTime(request.getDateTime());
        
        // Set product if provided
        if (request.getProductId() != null) {
            Product product = productRepository.findById(request.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + request.getProductId()));
            sell.setProduct(product);
        }
        
        // Set staff account if provided
        if (request.getStaffId() != null) {
            StaffAccount staffAccount = staffAccountRepository.findById(request.getStaffId())
                    .orElseThrow(() -> new RuntimeException("Staff account not found with id: " + request.getStaffId()));
            sell.setStaff(staffAccount);
        }
        
        // Save and return the sell
        return sellsRepository.save(sell);
    }
}