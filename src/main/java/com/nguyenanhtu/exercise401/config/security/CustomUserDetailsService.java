package com.nguyenanhtu.exercise401.config.security;

import com.nguyenanhtu.exercise401.entity.StaffAccount;
import com.nguyenanhtu.exercise401.repository.StaffAccountRepository;
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
public class CustomUserDetailsService implements UserDetailsService {

    private final StaffAccountRepository staffAccountRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Đảm bảo BCryptPasswordEncoder được

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        StaffAccount staffAccount = staffAccountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));

        // Ensure the password is encrypted (for testing purpose)
        if (!staffAccount.getPasswordHash().startsWith("$2a$")) {
            String encodedPassword = passwordEncoder.encode(staffAccount.getPasswordHash());
            staffAccount.setPasswordHash(encodedPassword); // Nên lưu lại vào database (trong thực tế)
        }

        // Create a SimpleGrantedAuthority based on the role name
        String roleName = staffAccount.getRoleId() != null ? "ROLE_" + staffAccount.getRoleId().toString()
                : "ROLE_USER";

        return User.builder()
                .username(staffAccount.getEmail())
                .password(staffAccount.getPasswordHash())
                .authorities(Collections.singleton(new SimpleGrantedAuthority(roleName)))
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(!staffAccount.getActive()) // Kiểm tra active
                .build();
    }
}
