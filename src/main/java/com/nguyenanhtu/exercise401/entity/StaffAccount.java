package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "staff_accounts")
public class StaffAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "id", nullable = false)
    @JsonIgnore
    private Role roleId = Role.getDefaultRole();

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "phone_number", length = 100, nullable = true)
    private String phoneNumber = null;

    @Column(name = "email", length = 255, nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(nullable = true)
    private Boolean active = true;

    @Column(nullable = true)
    private String image = null;

    @Column(nullable = true)
    private String placeholder = null;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name = "updated_at", nullable = false)
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    @JsonIgnore
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    @JsonIgnore
    private StaffAccount updatedBy;

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
        updatedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = new Date();
    }

    @Override
    public String toString() {
        return "StaffAccount{" +
                "id=" + id +
                " roleId=" + roleId +
                "" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", createdBy=" + (createdBy != null ? createdBy.getId() : "null") +
                ", updatedBy=" + (updatedBy != null ? updatedBy.getId() : "null") +
                ",image='" + image + '\'' +
                ", placeholder='" + placeholder + '\'' +
                ",phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public void setRole(Role role) {
        this.roleId = role;
    }
}
