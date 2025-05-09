package com.nguyenanhtu.exercise401.service;

import com.nguyenanhtu.exercise401.config.security.JwtUtil;
import com.nguyenanhtu.exercise401.controller.response.UserResponse;
import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
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
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final StaffAccountRepository staffAccountRepository;

    /**
     * Authenticate a user and generate a JWT token
     *
     * @param email    user's email
     * @param password user's password
     * @return JWT token if authentication is successful
     */
    public String authenticate(String email, String password) {
        // Authenticate the user

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password));

        // Get the authenticated user details
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        // Generate and return the JWT token
        return jwtUtil.generateToken(userDetails.getUsername());
    }

    /**
     * Get the current authenticated user's information
     *
     * @return UserResponse containing the user's information
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

        // Retrieve the staff account from the repository
        StaffAccount staffAccount = staffAccountRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));

        // Map the staff account to the user response
        return UserResponse.builder()
                .id(staffAccount.getId())
                .email(staffAccount.getEmail())
                .firstName(staffAccount.getFirstName())
                .lastName(staffAccount.getLastName())
                .phoneNumber(staffAccount.getPhoneNumber())
                .roleName(staffAccount.getRoleId() != null ? staffAccount.getRoleId().getRoleName() : null)
                .active(staffAccount.getActive())
                .build();
    }
}
