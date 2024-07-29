package com.example.inscope.dto.http.order.paging;


import com.example.inscope.domain.order.paging.OrderSort;
import com.example.inscope.dto.http.common.SortRequestDtoBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
public class OrderSortRequestDto implements SortRequestDtoBase<OrderSort> {

    private OrderSort sortBy = OrderSort.ID;
    private Sort.Direction sortDirection = Sort.Direction.ASC;

    @Override
    public OrderSort getSortBy() {
        return sortBy;
    }

    @Override
    public void setSortBy(OrderSort sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public Sort.Direction setSortDirection() {
        return sortDirection;
    }

    @Override
    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }
}
