package com.example.inscope.domain.order.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderSearchRequest {
    @NotNull
    private OrderPageRequest pageRequest;
    @NotNull
    private OrderFilterRequest filterRequest;
}
