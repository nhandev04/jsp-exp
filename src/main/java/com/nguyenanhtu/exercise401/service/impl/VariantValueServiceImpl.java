package com.nguyenanhtu.exercise401.service.impl;

import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nguyenanhtu.exercise401.entity.VariantValue;
import com.nguyenanhtu.exercise401.repository.VariantValueRepository;
import com.nguyenanhtu.exercise401.service.VariantValueService;

@Service
public class VariantValueServiceImpl implements VariantValueService {

    @Autowired
    private VariantValueRepository variantValueRepository;

    @Override
    public VariantValue createVariantValue(VariantValue variantValue) {
        return variantValueRepository.save(variantValue);
    }

    @Override
    public VariantValue getVariantValueById(UUID id) {
        return variantValueRepository.findById(id).orElse(null);
    }

    @Override
    public List<VariantValue> getAllVariantValues() {
        return variantValueRepository.findAll();
    }

    @Override
    public VariantValue updateVariantValue(VariantValue variantValue) {
        return variantValueRepository.save(variantValue);
    }

    @Override
    public void deleteVariantValue(UUID id) {
        variantValueRepository.deleteById(id);
    }
}