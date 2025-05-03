package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.dto.CustomerAdressRequest;
import com.nguyenanhtu.exercise401.entity.CustomerAdress;
import com.nguyenanhtu.exercise401.service.CustomerAdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customer-addresses")
public class CustomerAdressController {

    @Autowired
    private CustomerAdressService customerAdressService;

    @GetMapping
    public ResponseEntity<List<CustomerAdress>> getAllCustomerAddresses() {
        List<CustomerAdress> addresses = customerAdressService.getAllCustomerAddresses();
        return ResponseEntity.ok(addresses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerAdress> getCustomerAddressById(@PathVariable UUID id) {
        return customerAdressService.getCustomerAddressById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<CustomerAdress>> getCustomerAddressesByCustomerId(@PathVariable UUID customerId) {
        List<CustomerAdress> addresses = customerAdressService.getCustomerAddressesByCustomerId(customerId);
        return ResponseEntity.ok(addresses);
    }

    @PostMapping
    public ResponseEntity<CustomerAdress> addCustomerAddress(@RequestBody CustomerAdressRequest customerAdressRequest) {
        CustomerAdress createdAddress = customerAdressService.addCustomerAddress(customerAdressRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddress);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerAdress> updateCustomerAddress(@PathVariable UUID id, @RequestBody CustomerAdressRequest customerAdressRequest) {
        try {
            CustomerAdress updatedAddress = customerAdressService.updateCustomerAddress(id, customerAdressRequest);
            return ResponseEntity.ok(updatedAddress);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerAddress(@PathVariable UUID id) {
        customerAdressService.deleteCustomerAddress(id);
        return ResponseEntity.noContent().build();
    }
}