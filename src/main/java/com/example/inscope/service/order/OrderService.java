package com.example.inscope.service.order;

import com.example.inscope.domain.order.Order;
import com.example.inscope.domain.order.paging.OrderSearchRequest;
import com.example.inscope.service.common.BaseService;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderService extends BaseService<Order, Long> {

    List<Order> getAllByEmail(String email);

    List<Order> getAllBySurname(String surname);

    Page<Order> search(OrderSearchRequest request);

    List<Order> getAllByPhoneNumber(String phoneNumber);

    List<Order> getAllByAddress(String address);
}
