package com.example.inscope.endpoint.order;

import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.exception.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface OrderEndpoint {
    @Transactional(readOnly = true)
    OrderDto get(Long id) throws NotFoundException;

    @Transactional(readOnly = true)
    List<OrderDto> getAllByEmail(String email);

    @Transactional(readOnly = true)
    List<OrderDto> getAllBySurname(String surname);

    @Transactional(readOnly = true)
    Page<OrderDto> search(OrderSearchRequestDto requestDto) throws NotFoundException;

    @Transactional(readOnly = true)
    List<OrderDto> getAllByPhoneNumber(String phoneNumber);

    @Transactional(readOnly = true)
    List<OrderDto> getAllByAddress(String address);

    @Transactional
    OrderDto add(OrderRequest orderRequest) throws NotFoundException;

    @Transactional
    OrderDto update(Long id, OrderRequest orderRequest) throws NotFoundException;

    @Transactional
    OrderDto setConfirmed(Long id) throws NotFoundException;

    @Transactional
    void delete(Long id) throws NotFoundException;
}
