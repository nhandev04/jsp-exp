package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.dto.CountryRequest;
import com.nguyenanhtu.exercise401.entity.Country;
import com.nguyenanhtu.exercise401.repository.CountryRepository;
import com.nguyenanhtu.exercise401.service.CountryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Optional<Country> getCountryById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country addCountry(CountryRequest request) {
        Country country = new Country();
        return saveCountry(country, request);
    }

    @Override
    public Country updateCountry(Long id, CountryRequest request) {
        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + id));
        
        return saveCountry(country, request);
    }

    @Override
    public void deleteCountry(Long id) {
        countryRepository.deleteById(id);
    }
    
    private Country saveCountry(Country country, CountryRequest request) {
        // Set basic properties
        country.setName(request.getName());
        country.setIso2(request.getIso2());
        country.setIso3(request.getIso3());
        country.setNumCode(request.getNumCode());
        country.setPhoneCode(request.getPhoneCode());
        
        // Save and return the country
        return countryRepository.save(country);
    }
}