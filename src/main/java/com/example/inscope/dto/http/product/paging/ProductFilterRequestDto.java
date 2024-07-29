package com.example.inscope.dto.http.product.paging;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductFilterRequestDto {

    private String name;

    private Long id;

    private LocalDate createdDateFrom;

    private LocalDate createdDateTo;

    private String description;

    private Long price;

}
