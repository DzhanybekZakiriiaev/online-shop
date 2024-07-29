package com.example.inscope.domain.product.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductFilterRequest {
    private Long id;
    private String name;
    private LocalDateTime createdDateFrom;
    private LocalDateTime createdDateTo;
    private String description;
    private Long price;
}
