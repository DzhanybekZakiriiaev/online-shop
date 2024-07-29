package com.example.inscope.service.order.impl;

import com.example.inscope.domain.order.Order;
import com.example.inscope.domain.order.paging.OrderFilterRequest;
import com.example.inscope.domain.order.paging.OrderSearchRequest;
import com.example.inscope.repository.order.OrderRepository;
import com.example.inscope.service.common.impl.DefaultBaseService;
import com.example.inscope.service.order.OrderService;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static java.util.Objects.nonNull;
import static com.example.inscope.domain.order.QOrder.order;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultOrderService extends DefaultBaseService<Order, Long> implements OrderService {
    OrderRepository repository;

    public DefaultOrderService(@Qualifier("orderRepository") CrudRepository<Order, Long> crudRepository,
                              OrderRepository repository) {
        super(crudRepository);
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllByEmail(String email) {
        return repository.findAllByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllBySurname(String surname) {
        return repository.findAllBySurname(surname);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Order> search(OrderSearchRequest request) {
        BooleanBuilder predicate = new BooleanBuilder();
        OrderFilterRequest filter = request.getFilterRequest();

        search(predicate, filter);
        return repository.findAll(predicate, request.getPageRequest());
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllByPhoneNumber(String phoneNumber) {
        return repository.findAllByPhoneNumber(phoneNumber);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Order> getAllByAddress(String address) {
        return repository.findAllByAddress(address);
    }

    private void search(BooleanBuilder predicate, OrderFilterRequest filter) {
        if (nonNull(filter.getId())) {
            predicate.and(order.id.eq(filter.getId()));
        }
        if (nonNull(filter.getName())) {
            predicate.and(order.name.contains(filter.getName()));
        }
        if (nonNull(filter.getSurname())) {
            predicate.and(order.surname.contains(filter.getSurname()));
        }
        if (nonNull(filter.getEmail())) {
            predicate.and(order.email.contains(filter.getEmail()));
        }
        if (nonNull(filter.getPhoneNumber())) {
            predicate.and(order.phoneNumber.contains(filter.getPhoneNumber()));
        }
        if (nonNull(filter.getCreatedDateFrom())) {
            predicate.and(order.createdAt.goe(filter.getCreatedDateFrom()));
        }
        if (nonNull(filter.getCreatedDateTo())) {
            predicate.and(order.createdAt.loe(filter.getCreatedDateTo().toLocalDate().atTime(LocalTime.MAX)));
        }
        if (nonNull(filter.getAddress())) {
            predicate.and(order.address.contains(filter.getAddress()));
        }
        if (nonNull(filter.getConfirmedDateFrom())) {
            predicate.and(order.confirmedAt.goe(filter.getConfirmedDateFrom()));
        }
        if (nonNull(filter.getConfirmedDateTo())) {
            predicate.and(order.confirmedAt.loe(filter.getConfirmedDateTo().toLocalDate().atTime(LocalTime.MAX)));
        }

    }
}
