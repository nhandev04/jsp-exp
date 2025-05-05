package com.nguyenanhtu.exercise401.entity;

import java.util.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Table(name = "categories")
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id", referencedColumnName = "id", nullable = true)
    @Fetch(FetchMode.JOIN)
    private Category parent;

    @Column(name = "category_name", nullable = false, unique = true, length = 255)
    private String categoryName;

    @Column(name = "category_description")
    private String categoryDescription;

    @Column
    private String icon;

    @Column
    private String image;

    @Column
    private String placeholder;

    @Column(nullable = false)
    private Boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    @Fetch(FetchMode.JOIN)
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by")
    @JsonBackReference
    private StaffAccount updatedBy;

}