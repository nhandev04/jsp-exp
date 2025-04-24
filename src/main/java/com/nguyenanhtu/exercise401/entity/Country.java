package com.nguyenanhtu.exercise401.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "countries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "iso", nullable = false, length = 2)
    private String iso;

    @Column(name = "name", nullable = false, length = 80)
    private String name;

    @Column(name = "upper_name", nullable = false, length = 80)
    private String upperName;

    @Column(name = "iso3", length = 3)
    private String iso3;

    @Column(name = "num_code")
    private Short numCode;

    @Column(name = "phone_code", nullable = false)
    private Integer phoneCode;
}
