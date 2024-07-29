package com.example.inscope.domain.product;

import com.example.inscope.domain.common.BaseEntity;
import com.example.inscope.domain.attachment.Attachment;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "products")
public class Product extends BaseEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "model")
    private String model;

    @Column(name = "price", nullable = false)
    private Long price;

    @Column(name = "price_opt", nullable = false)
    private Long priceOpt;

    @Column(name = "price_advance", nullable = false)
    private Long priceAdvance;

    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Attachment> attachments;
}
