package com.nguyenanhtu.exercise401.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "slideshows")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SlideShow {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title")
    private String title;

    @Column(name = "destination_url")
    private String destinationUrl;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "placeholder", nullable = false)
    private String placeholder;

    @Column(name = "description", length = 160)
    private String description;

    @Column(name = "btn_label", length = 50)
    private String btnLabel;

    @Column(name = "display_order", nullable = false)
    private Integer displayOrder;

    @Column(name = "published", nullable = false)
    private Boolean published = false;

    @Column(name = "clicks", nullable = false)
    private Integer clicks = 0;

    @Column(name = "styles")
    private String styles;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private StaffAccount updatedBy;
}
