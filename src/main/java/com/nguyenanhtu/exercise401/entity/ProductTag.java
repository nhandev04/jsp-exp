package com.nguyenanhtu.exercise401.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "product_tags")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductTag {

    @EmbeddedId
    private ProductTagId id;

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
}
