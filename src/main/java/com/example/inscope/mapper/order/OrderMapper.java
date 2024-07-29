package com.example.inscope.mapper.order;

import com.example.inscope.domain.order.Order;
import com.example.inscope.domain.order.paging.OrderSearchRequest;
import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.exception.NotFoundException;

import java.util.Collection;

public interface OrderMapper {

    OrderDto toDto(Order order);

    Order toOrder(OrderRequest orderRequest);

    Collection<OrderDto> toDto(Collection<Order> orders);

    public OrderSearchRequest toSearchRequest(OrderSearchRequestDto requestDto) throws NotFoundException;

}
