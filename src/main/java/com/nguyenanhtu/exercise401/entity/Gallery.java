package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "gallery")
public class Gallery extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    @Column(name = "id", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "placeholder", nullable = false)
    private String placeholder;

    @Column(name = "is_thumbnail")
    private Boolean isThumbnail = false;

}
