package com.nguyenanhtu.exercise401.config.security;

import com.nguyenanhtu.exercise401.entity.Customer;
import com.nguyenanhtu.exercise401.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class CustomerUserDetailsService implements UserDetailsService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));

        // Ensure the password is encrypted (for testing purpose)
        if (!customer.getPasswordHash().startsWith("$2a$")) {
            String encodedPassword = passwordEncoder.encode(customer.getPasswordHash());
            customer.setPasswordHash(encodedPassword);
        }

        return User.builder()
                .username(customer.getEmail())
                .password(customer.getPasswordHash())
                .authorities(Collections.singleton(new SimpleGrantedAuthority("ROLE_CUSTOMER")))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!customer.getActive())
                .build();
    }
}