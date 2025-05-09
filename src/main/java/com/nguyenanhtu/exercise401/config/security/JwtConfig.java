package com.nguyenanhtu.exercise401.config.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

/**
 * Configuration for JWT, providing secret key, expiration, token prefix, and
 * header settings.
 */
@Configuration
public class JwtConfig {

    private final SecretKey secretKey;
    private final long expiration;
    private final String tokenPrefix;
    private final String header;

    public JwtConfig(
            JwtKeyManager keyManager,
            @Value("${jwt.expiration}") long expiration,
            @Value("${jwt.token-prefix}") String tokenPrefix,
            @Value("${jwt.header}") String header) {

        // Use the key manager to get the secret key
        this.secretKey = keyManager.getSecretKey();

        this.expiration = expiration * 1000; // Convert to milliseconds
        this.tokenPrefix = tokenPrefix;
        this.header = header;
    }

    // Getter methods for the fields

    /**
     * Returns the decoded secret key used for signing JWTs.
     * 
     * @return the secret key
     */
    public SecretKey getSecretKey() {
        return secretKey;
    }

    /**
     * Returns the expiration time of the JWT in milliseconds.
     * 
     * @return the expiration time
     */
    public long getExpiration() {
        return expiration;
    }

    /**
     * Returns the token prefix to be used in the header.
     * 
     * @return the token prefix
     */
    public String getTokenPrefix() {
        return tokenPrefix;
    }

    /**
     * Returns the header where the JWT is stored.
     * 
     * @return the header name
     */
    public String getHeader() {
        return header;
    }
}
