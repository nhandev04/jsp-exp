package com.nguyenanhtu.exercise401.controller;

import com.nguyenanhtu.exercise401.controller.request.LoginRequest;
import com.nguyenanhtu.exercise401.controller.response.AuthResponse;
import com.nguyenanhtu.exercise401.controller.response.UserResponse;
import com.nguyenanhtu.exercise401.service.StaffAuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final StaffAuthenticationService staffAuthenticationService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {

        String token = staffAuthenticationService.authenticate(
                loginRequest.getEmail(),
                loginRequest.getPassword());

        return ResponseEntity.ok(new AuthResponse(token));
    }

    /**
     * Get the current authenticated user's information
     * 
     * @return ResponseEntity containing the user's information
     */
    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser() {
        UserResponse userResponse = staffAuthenticationService.getCurrentUser();
        return ResponseEntity.ok(userResponse);
    }
}
