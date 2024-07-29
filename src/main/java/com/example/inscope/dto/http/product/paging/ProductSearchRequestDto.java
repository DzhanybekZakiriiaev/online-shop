package com.example.inscope.dto.http.product.paging;

import com.example.inscope.dto.http.common.PageRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchRequestDto {

    @Valid
    @NotNull
    private PageRequestDto pageRequest = new PageRequestDto();

    @Valid
    @NotNull
    private ProductSortRequestDto sorting = new ProductSortRequestDto();

    @Valid
    private ProductFilterRequestDto filter;
}
