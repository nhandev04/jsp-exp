package com.nguyenanhtu.exercise401.config.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
@Slf4j
public class RequestLoggingFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException {

        // Log request details
        log.info("Request: {} {}", request.getMethod(), request.getRequestURI());

        // Log headers
        Collections.list(request.getHeaderNames())
                .forEach(headerName -> log.info("Header: {} = {}", headerName, request.getHeader(headerName)));

        // Continue with the filter chain
        filterChain.doFilter(request, response);

        // Log response status
        log.info("Response Status: {}", response.getStatus());
    }
}