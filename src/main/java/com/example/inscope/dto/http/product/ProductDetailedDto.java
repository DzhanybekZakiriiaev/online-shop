package com.example.inscope.dto.http.product;

import com.example.inscope.dto.http.attachment.AttachmentDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailedDto {

    private Long id;

    private String name;

    private String model;

    private String description;

    private Long price;

    private Long priceOpt;

    private Long priceAdvance;

    private Collection<AttachmentDto> attachmentDtos;
}
