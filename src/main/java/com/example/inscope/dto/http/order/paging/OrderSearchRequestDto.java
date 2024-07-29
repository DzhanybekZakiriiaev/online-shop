package com.example.inscope.dto.http.order.paging;

import com.example.inscope.dto.http.common.PageRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchRequestDto {

    @Valid
    @NotNull
    private PageRequestDto pageRequest = new PageRequestDto();

    @Valid
    @NotNull
    private OrderSortRequestDto sorting = new OrderSortRequestDto();

    @Valid
    private OrderFilterRequestDto filter;
}
