package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "role_name", nullable = false, length = 255)
    private String roleName;

    @Column(nullable = true)
    private String privileges;

    public static Optional<Role> findById(UUID id) {
        return roles.stream().filter(role -> role.getId().equals(id)).findFirst();
    }

    private static List<Role> roles = new ArrayList<>();
}