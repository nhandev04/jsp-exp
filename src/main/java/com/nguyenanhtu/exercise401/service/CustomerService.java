package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.request.CustomerRequest;
import com.nguyenanhtu.exercise401.entity.Customer;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerService {
    List<Customer> getAllCustomers();
    
    Optional<Customer> getCustomerById(UUID id);
    
    Optional<Customer> getCustomerByEmail(String email);
    
    Customer addCustomer(CustomerRequest request);
    
    Customer updateCustomer(UUID id, CustomerRequest request);
    
    void deleteCustomer(UUID id);
}