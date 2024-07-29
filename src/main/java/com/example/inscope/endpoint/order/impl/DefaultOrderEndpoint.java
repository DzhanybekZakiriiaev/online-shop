package com.example.inscope.endpoint.order.impl;

import com.example.inscope.domain.order.Order;
import com.example.inscope.domain.order.paging.OrderSearchRequest;
import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.endpoint.order.OrderEndpoint;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.mapper.order.OrderMapper;
import com.example.inscope.service.email.EmailService;
import com.example.inscope.service.order.OrderService;
import com.example.inscope.service.product.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultOrderEndpoint implements OrderEndpoint {

    OrderService orderService;
    OrderMapper orderMapper;

    ProductService productService;
    EmailService emailService;

    @Override
    @Transactional(readOnly = true)
    public OrderDto get(Long id) throws NotFoundException {
        Order order = orderService.get(id);
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAllByEmail(String email) {
        List<Order> orders = orderService.getAllByEmail(email);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAllBySurname(String surname) {
        List<Order> orders = orderService.getAllBySurname(surname);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public Page<OrderDto> search(OrderSearchRequestDto requestDto) throws NotFoundException {
        OrderSearchRequest request = orderMapper.toSearchRequest(requestDto);
        Page<Order> page = orderService.search(request);

        List<OrderDto> dtos = page.getContent().stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());

        return page.map(orderMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAllByPhoneNumber(String phoneNumber) {
        List<Order> orders = orderService.getAllByPhoneNumber(phoneNumber);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrderDto> getAllByAddress(String address) {
        List<Order> orders = orderService.getAllByAddress(address);
        return orders.stream()
                .map(orderMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public OrderDto add(OrderRequest orderRequest) throws NotFoundException {
        Order order = orderMapper.toOrder(orderRequest);
        order.setProduct(productService.get(orderRequest.getProductId()));
        orderService.saveOrUpdate(order);
        emailService.sendAdminMail("Поступил новый заказ!");
        return orderMapper.toDto(order);
    }

    @Override
    @Transactional
    public OrderDto update(Long id, OrderRequest orderRequest) throws NotFoundException {
        Order existingOrder = orderService.get(id);
        Order updatedOrder = orderMapper.toOrder(orderRequest);
        updatedOrder.setProduct(productService.get(orderRequest.getProductId()));
        updatedOrder.setId(existingOrder.getId());
        orderService.saveOrUpdate(updatedOrder);
        return orderMapper.toDto(updatedOrder);
    }

    @Override
    @Transactional
    public OrderDto setConfirmed(Long id) throws NotFoundException {
        Order existingOrder = orderService.get(id);
        existingOrder.setConfirmed(true);
        existingOrder.setConfirmedAt(LocalDateTime.now());
        orderService.saveOrUpdate(existingOrder);
        emailService.send(existingOrder.getEmail().toLowerCase(),"Ваш заказ был принят!");
        return orderMapper.toDto(existingOrder);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        Order order = orderService.get(id);
        orderService.delete(order);
    }

    public String formatOrderDetails(Order order) {
        StringBuilder details = new StringBuilder(
                String.format(
                        "Поступил новый заказ:\n" +
                                "Имя: %s\n" +
                                "Фамилия: %s\n" +
                                "Адрес электронной почты: %s\n" +
                                "Номер телефона: %s\n" +
                                "Адрес Доставки: %s\n" +
                                "Продукт: %s\n" +
                                "Описание: %s\n",
                        order.getName(),
                        order.getSurname(),
                        order.getEmail(),
                        order.getPhoneNumber(),
                        order.getAddress(),
                        order.getProduct().getName(),
                        order.getDescription()

                )
        );

        return details.toString();
    }


}
