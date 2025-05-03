package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.controller.dto.CustomerAdressRequest;
import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerAdressService {
    List<CustomerAdress> getAllCustomerAddresses();
    
    Optional<CustomerAdress> getCustomerAddressById(UUID id);
    
    List<CustomerAdress> getCustomerAddressesByCustomerId(UUID customerId);

    CustomerAdress addCustomerAddress(CustomerAdressRequest request);
    
    CustomerAdress updateCustomerAddress(UUID id, CustomerAdressRequest request);
    
    void deleteCustomerAddress(UUID id);
}