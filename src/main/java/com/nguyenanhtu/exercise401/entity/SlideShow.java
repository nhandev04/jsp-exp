package com.nguyenanhtu.exercise401.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "slideshows")
public class SlideShow extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "title", length = 80)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private StaffAccount createdBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private StaffAccount updatedBy;
}
