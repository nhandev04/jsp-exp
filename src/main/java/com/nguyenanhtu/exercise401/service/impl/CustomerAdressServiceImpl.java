package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import com.nguyenanhtu.exercise401.repository.CustomerAdressRepository;
import com.nguyenanhtu.exercise401.service.CustomerAdressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CustomerAdressServiceImpl implements CustomerAdressService {

    private final CustomerAdressRepository customerAdressRepository;

    @Override
    public List<CustomerAdress> getAllCustomerAddresses() {
        return customerAdressRepository.findAll();
    }

    @Override
    public Optional<CustomerAdress> getCustomerAddressById(UUID id) {
        return customerAdressRepository.findById(id);
    }

    @Override
    public List<CustomerAdress> getCustomerAddressesByCustomerId(UUID customerId) {
        return customerAdressRepository.findByCustomerId(customerId);
    }

    @Override
    public CustomerAdress addCustomerAddress(CustomerAdress customerAddress) {
        return customerAdressRepository.save(customerAddress);
    }

    @Override
    public CustomerAdress updateCustomerAddress(CustomerAdress customerAddress) {
        return customerAdressRepository.save(customerAddress);
    }

    @Override
    public void deleteCustomerAddress(UUID id) {
        customerAdressRepository.deleteById(id);
    }
}