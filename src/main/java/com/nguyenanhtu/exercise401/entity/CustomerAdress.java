package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer_addresses")
public class CustomerAdress {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;

    @Column(name = "address_line1", nullable = false)
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(name = "phone_number", nullable = false, length = 255)
    private String phoneNumber;

    @Column(name = "dial_code", nullable = false, length = 100)
    private String dialCode;

    @Column(name = "country", nullable = false, length = 255)
    private String country;

    @Column(name = "postal_code", nullable = false, length = 255)
    private String postalCode;

    @Column(name = "city", nullable = false, length = 255)
    private String city;

    public String getCustomer() {
        return customer.getId() != null ? customer.getId().toString() : null;
    }
}
