package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import com.nguyenanhtu.exercise401.controller.request.CustomerAdressRequest;
import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.repository.CustomerAdressRepository;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import com.nguyenanhtu.exercise401.service.CustomerAdressService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerAdressServiceImpl implements CustomerAdressService {

    private final CustomerAdressRepository customerAdressRepository;
    private final CustomerRepository customerRepository;

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
    public CustomerAdress addCustomerAddress(CustomerAdressRequest request) {
        CustomerAdress customerAdress = new CustomerAdress();
        return saveCustomerAddress(customerAdress, request);
    }

    @Override
    public CustomerAdress updateCustomerAddress(UUID id, CustomerAdressRequest request) {
        CustomerAdress customerAdress = customerAdressRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer address not found with id: " + id));
        
        return saveCustomerAddress(customerAdress, request);
    }

    @Override
    public void deleteCustomerAddress(UUID id) {
        customerAdressRepository.deleteById(id);
    }
    
    private CustomerAdress saveCustomerAddress(CustomerAdress customerAdress, CustomerAdressRequest request) {
        // Set basic properties
        customerAdress.setAddressLine1(request.getAddressLine1());
        customerAdress.setAddressLine2(request.getAddressLine2());
        customerAdress.setPhoneNumber(request.getPhoneNumber());
        customerAdress.setDialCode(request.getDialCode());
        customerAdress.setCountry(request.getCountry());
        customerAdress.setPostalCode(request.getPostalCode());
        
        // Set customer if provided
        if (request.getCustomerId() != null) {
            Customer customer = customerRepository.findById(request.getCustomerId())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomerId()));
            customerAdress.setCustomer(customer);
        }
        
        // Save and return the customer address
        return customerAdressRepository.save(customerAdress);
    }
}