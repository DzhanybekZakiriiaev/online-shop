package com.example.inscope.domain.product.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchRequest {
    @NotNull
    private ProductPageRequest pageRequest;
    @NotNull
    private ProductFilterRequest filterRequest;
}
