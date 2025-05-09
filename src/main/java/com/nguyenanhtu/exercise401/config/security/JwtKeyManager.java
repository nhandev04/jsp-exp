package com.nguyenanhtu.exercise401.config.security;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.security.SecureRandom;

/**
 * Manages the JWT secret key, ensuring it remains consistent across server
 * restarts.
 * The key is stored in a file and read from there. If the file doesn't exist,
 * a new key is generated and saved to the file.
 */
@Component
public class JwtKeyManager {

    private static final String KEY_FILE_PATH = "jwt-key.txt";
    private static final int KEY_LENGTH = 32; // 256 bits
    private final SecretKey secretKey;

    public JwtKeyManager(@Value("${jwt.secret:}") String configSecret) {
        String secret = loadOrCreateKeyFile(configSecret);
        this.secretKey = Keys.hmacShaKeyFor(Base64.getDecoder().decode(secret));
    }

    /**
     * Loads the secret key from the file or creates a new one if the file doesn't
     * exist.
     * 
     * @param configSecret The secret from the configuration, used as a fallback
     * @return The secret key as a Base64-encoded string
     */
    private String loadOrCreateKeyFile(String configSecret) {
        try {
            Path keyPath = Paths.get(KEY_FILE_PATH);

            // Check if the key file exists
            if (Files.exists(keyPath)) {
                // Read the key from the file
                String key = new String(Files.readAllBytes(keyPath), StandardCharsets.UTF_8).trim();
                if (!key.isEmpty()) {
                    return key;
                }
            }

            // If we reach here, either the file doesn't exist or it's empty
            // Generate a new key
            String newKey = configSecret.isEmpty() ? generateNewKey() : configSecret;

            // Save the key to the file
            Files.write(keyPath, newKey.getBytes(StandardCharsets.UTF_8));

            return newKey;
        } catch (IOException e) {
            // If there's an error reading/writing the file, fall back to the config secret
            // or generate a new one
            if (!configSecret.isEmpty()) {
                return configSecret;
            }
            return generateNewKey();
        }
    }

    /**
     * Generates a new random key and encodes it as Base64.
     * 
     * @return A new random key as a Base64-encoded string
     */
    private String generateNewKey() {
        byte[] key = new byte[KEY_LENGTH];
        new SecureRandom().nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    /**
     * Returns the secret key.
     * 
     * @return The secret key
     */
    public SecretKey getSecretKey() {
        return secretKey;
    }
}