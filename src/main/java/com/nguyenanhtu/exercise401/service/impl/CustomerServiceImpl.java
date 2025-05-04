package com.nguyenanhtu.exercise401.service.impl;

import com.nguyenanhtu.exercise401.controller.request.CustomerRequest;
import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import com.nguyenanhtu.exercise401.service.CustomerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Optional<Customer> getCustomerById(UUID id) {
        return customerRepository.findById(id);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    private String hashPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(password); 
    }

    public Customer addCustomer(CustomerRequest request) {
        Customer customer = new Customer();

        String hashedPassword = hashPassword(request.getPassword());
    
        customer.setPasswordHash(hashedPassword);
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        customer.setActive(request.getActive());
    
        return saveCustomer(customer, request);
    }

    @Override
    public Customer updateCustomer(UUID id, CustomerRequest request) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
        
        return saveCustomer(customer, request);
    }

    @Override
    public void deleteCustomer(UUID id) {
        customerRepository.deleteById(id);
    }
    
    private Customer saveCustomer(Customer customer, CustomerRequest request) {
        customer.setFirstName(request.getFirstName());
        customer.setLastName(request.getLastName());
        customer.setEmail(request.getEmail());
        
        // Only hash the password if it's provided in the request
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            String hashedPassword = hashPassword(request.getPassword());
            customer.setPasswordHash(hashedPassword);
        }
        
        customer.setActive(request.getActive());
        
        // Set registration date for new customers
        if (customer.getId() == null && customer.getRegisteredAt() == null) {
            customer.setRegisteredAt(LocalDateTime.now());
        }
        
        // Save and return the customer
        return customerRepository.save(customer);
    }
}