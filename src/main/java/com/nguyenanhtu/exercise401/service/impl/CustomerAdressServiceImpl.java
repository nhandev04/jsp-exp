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
        if (request.getAddressLine1() != null) {
            customerAdress.setAddressLine1(request.getAddressLine1());
        }
        if (request.getAddressLine2() != null) {
            customerAdress.setAddressLine2(request.getAddressLine2());
        }
        if (request.getPhoneNumber() != null) {
            customerAdress.setPhoneNumber(request.getPhoneNumber());
        }
        if (request.getDialCode() != null) {
            customerAdress.setDialCode(request.getDialCode());
        }
        if (request.getCountry() != null) {
            customerAdress.setCountry(request.getCountry());
        }
        if (request.getPostalCode() != null) {
            customerAdress.setPostalCode(request.getPostalCode());
        }
        if (request.getCity() != null) {
            customerAdress.setCity(request.getCity());
        }

        // Set customer if provided
        if (request.getCustomer() != null) {
            Customer customer = customerRepository.findById(request.getCustomer())
                    .orElseThrow(() -> new RuntimeException("Customer not found with id: " + request.getCustomer()));
            customerAdress.setCustomer(customer);
        }

        // Save and return the customer address
        return customerAdressRepository.save(customerAdress);
    }
}