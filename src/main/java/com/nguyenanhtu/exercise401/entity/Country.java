package com.nguyenanhtu.exercise401.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "country_seq_generator")
    @SequenceGenerator(name = "country_seq_generator", sequenceName = "countries_seq", allocationSize = 1)
    @Column(nullable = false)
    private Long id = 0L;

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
