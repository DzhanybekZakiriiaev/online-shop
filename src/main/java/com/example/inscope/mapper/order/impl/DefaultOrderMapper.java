package com.example.inscope.mapper.order.impl;

import com.example.inscope.domain.order.Order;
import com.example.inscope.domain.order.paging.OrderFilterRequest;
import com.example.inscope.domain.order.paging.OrderPageRequest;
import com.example.inscope.domain.order.paging.OrderSearchRequest;
import com.example.inscope.domain.order.paging.OrderSort;
import com.example.inscope.domain.paging.PageInfo;
import com.example.inscope.domain.paging.sorting.SortInfo;
import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderFilterRequestDto;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.mapper.order.OrderMapper;
import com.example.inscope.mapper.product.ProductMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultOrderMapper implements OrderMapper {

    private final ProductMapper productMapper;

    @Override
    @Transactional(readOnly = true)
    public OrderDto toDto(Order order) {
        return OrderDto.builder()
                .address(order.getAddress())
                .email(order.getEmail())
                .name(order.getName())
                .surname(order.getSurname())
                .isConfirmed(order.isConfirmed())
                .phoneNumber(order.getPhoneNumber())
                .description(order.getDescription())
                .productDto(productMapper.toDto(order.getProduct()))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Order toOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setAddress(orderRequest.getAddress());
        order.setEmail(orderRequest.getEmail());
        order.setName(orderRequest.getName());
        order.setPhoneNumber(orderRequest.getPhoneNumber());
        order.setConfirmed(false);
        order.setDescription(order.getDescription());
        return order;
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<OrderDto> toDto(Collection<Order> orders) {
        Collection<OrderDto> orderDtos = new ArrayList<>();
        for(Order order : orders){
            orderDtos.add(toDto(order));
        }
        return orderDtos;
    }

    @Override
    @Transactional(readOnly = true)
    public OrderSearchRequest toSearchRequest(OrderSearchRequestDto requestDto) throws NotFoundException {
        OrderPageRequest pageRequest = toPageRequest(requestDto);
        OrderFilterRequest filter = toFilterRequest(requestDto.getFilter());

        return OrderSearchRequest.builder().pageRequest(pageRequest).filterRequest(filter).build();
    }

    private OrderPageRequest toPageRequest(OrderSearchRequestDto requestDto) {
        PageInfo pageInfo = new PageInfo(requestDto.getPageRequest().getPage(), requestDto.getPageRequest().getLimit());

        SortInfo<OrderSort> sortInfo = new SortInfo<>(requestDto.getSorting().getSortBy(), requestDto.getSorting().setSortDirection());

        return new OrderPageRequest(pageInfo, sortInfo);
    }

    private OrderFilterRequest toFilterRequest(OrderFilterRequestDto requestDto) throws NotFoundException {
        OrderFilterRequest filterRequest = new OrderFilterRequest();

        if (Objects.isNull(requestDto))
            return filterRequest;

        if (nonNull(requestDto.getAddress()))
            filterRequest.setAddress(requestDto.getAddress());

        if (nonNull(requestDto.getEmail()))
            filterRequest.setEmail(requestDto.getEmail());

        if (nonNull(requestDto.getName()))
            filterRequest.setName(requestDto.getName());

        if (nonNull(requestDto.getSurname()))
            filterRequest.setSurname(requestDto.getSurname());

        if (nonNull(requestDto.getPhoneNumber()))
            filterRequest.setPhoneNumber(requestDto.getPhoneNumber());

        if (nonNull(requestDto.getCreatedDateFrom()))
            filterRequest.setCreatedDateFrom(requestDto.getCreatedDateFrom().atStartOfDay());

        if (nonNull(requestDto.getCreatedDateTo()))
            filterRequest.setCreatedDateTo(requestDto.getCreatedDateTo().atStartOfDay());

        return filterRequest;
    }
}
