package com.example.inscope.domain.attachment;

import com.example.inscope.domain.common.BaseEntity;
import com.example.inscope.domain.product.Product;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "attachments")
public class Attachment extends BaseEntity {

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @NotNull
    @Column(name = "content_type")
    private String contentType;

    @NotNull
    @Lob
    @Column(name = "content")
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] content;
}

