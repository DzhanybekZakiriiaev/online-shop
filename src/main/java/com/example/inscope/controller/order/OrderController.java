package com.example.inscope.controller.order;

import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.endpoint.order.OrderEndpoint;
import com.example.inscope.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderEndpoint orderEndpoint;

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrder(@PathVariable Long id) {
        try {
            OrderDto orderDto = orderEndpoint.get(id);
            return ResponseEntity.ok(orderDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderRequest orderRequest) {
        try {
            OrderDto savedOrder = orderEndpoint.add(orderRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
