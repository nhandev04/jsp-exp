package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.config.security.JwtUtil;
import com.nguyenanhtu.exercise401.controller.response.UserResponse;
import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CustomerAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomerRepository customerRepository;

    /**
     * Authenticate a customer and generate a JWT token
     * 
     * @param email    customer's email
     * @param password customer's password
     * @return JWT token if authentication is successful
     */
    public String authenticate(String email, String password) {
        // Authenticate the customer
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        // Get the authenticated user details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generate and return the JWT token
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    /**
     * Get the current authenticated customer's information
     * 
     * @return UserResponse containing the customer's information
     */
    @Transactional
    public UserResponse getCurrentUser() {
        // Get the current authentication from the security context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User not authenticated");
        }

        // Get the username (email) from the authentication
        String email = authentication.getName();

        // Retrieve the customer from the repository
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Customer not found with email: " + email));

        // Map the customer to the user response
        return UserResponse.builder()
                .id(customer.getId())
                .email(customer.getEmail())
                .firstName(customer.getFirstName())
                .lastName(customer.getLastName())
                .roleName("ROLE_CUSTOMER")
                .active(customer.getActive())
                .build();
    }
}