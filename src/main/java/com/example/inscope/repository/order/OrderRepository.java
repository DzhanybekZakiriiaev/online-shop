package com.example.inscope.repository.order;

import com.example.inscope.domain.order.Order;
import com.example.inscope.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    List<Order> findAllByEmail(String email);

    List<Order> findAllBySurname(String surname);

    List<Order> findAllByPhoneNumber(String phoneNumber);

    List<Order> findAllByAddress(String address);
}
