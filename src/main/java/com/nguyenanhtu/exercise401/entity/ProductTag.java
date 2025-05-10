package com.nguyenanhtu.exercise401.entity;

import java.io.Serializable;
import java.util.*;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
    @Fetch(FetchMode.JOIN)
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    @JsonIgnore
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @MapsId("tagId")
    @JoinColumn(name = "tag_id")
    private Tag tag;

    @Column(name = "is_primary")    
    @JsonIgnore
    private Boolean isPrimary = false;


    public String getTagName() {
        return tag != null ? tag.getTagName() : null;
    }
    
    public String getProductId () {
        return product != null ? product.getId().toString() : null;
    }

    public String getTagId () {
        return tag != null ? tag.getId().toString() : null;
    }

    public String getProductName () {
        return product != null ? product.getProductName() : null;
    }


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
