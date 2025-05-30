package com.nguyenanhtu.exercise401.entity;

import java.io.Serializable;
import java.util.*;
import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_tags")
public class ProductTag {

    @EmbeddedId
    @JsonIgnore
    private ProductTagId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "is_primary")
    @JsonIgnore
    private Boolean isPrimary = false;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Embeddable
    public static class ProductTagId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "product_id", nullable = false)
        private UUID productId;

        @Column(name = "tag_id", nullable = false)
        private UUID tagId;
    }

    // Helper methods to get string representations of IDs
    public String getProduct() {
        return product != null && product.getId() != null ? product.getId().toString() : null;
    }

    public String getTag() {
        return tag != null && tag.getId() != null ? tag.getId().toString() : null;
    }
}
