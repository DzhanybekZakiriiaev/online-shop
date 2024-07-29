package com.example.inscope.controller.admin;

import com.example.inscope.dto.http.attachment.AttachmentDto;
import com.example.inscope.dto.http.common.PageResponseDto;
import com.example.inscope.dto.http.order.OrderDto;
import com.example.inscope.dto.http.order.OrderRequest;
import com.example.inscope.dto.http.order.paging.OrderSearchRequestDto;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.endpoint.attachment.AttachmentEndpoint;
import com.example.inscope.endpoint.order.OrderEndpoint;
import com.example.inscope.endpoint.product.ProductEndpoint;
import com.example.inscope.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final ProductEndpoint productEndpoint;
    private final AttachmentEndpoint attachmentEndpoint;
    private final OrderEndpoint orderEndpoint;

    @PostMapping("/products")
    public ResponseEntity<ProductDto> addProduct(@RequestPart("product") AddProductRequestDto requestDto,
                                                 @RequestPart("attachments") List<MultipartFile> attachments) {
        try {
            ProductDto productDto = productEndpoint.add(requestDto, attachments);
            return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/products/{id}")
    public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id, @RequestBody UpdateProductRequestDto requestDto) {
        try {
            ProductDto productDto = productEndpoint.update(id, requestDto);
            return ResponseEntity.ok(productDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        try {
            productEndpoint.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/attachments")
    public ResponseEntity<AttachmentDto> uploadAttachment(@RequestParam("file") MultipartFile file, @RequestParam("productId") Long productId) {
        try {
            AttachmentDto attachmentDto = attachmentEndpoint.uploadAttachment(file, productId);
            return ResponseEntity.status(HttpStatus.CREATED).body(attachmentDto);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/orders/email/{email}")
    public ResponseEntity<List<OrderDto>> getOrdersByEmail(@PathVariable String email) {
        List<OrderDto> orders = orderEndpoint.getAllByEmail(email);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/surname/{surname}")
    public ResponseEntity<List<OrderDto>> getOrdersBySurname(@PathVariable String surname) {
        List<OrderDto> orders = orderEndpoint.getAllBySurname(surname);
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/orders/search")
    public ResponseEntity<Page<OrderDto>> searchOrders(@RequestBody OrderSearchRequestDto requestDto) {
        try {
            Page<OrderDto> orders = orderEndpoint.search(requestDto);
            return ResponseEntity.ok(orders);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/orders/phone/{phoneNumber}")
    public ResponseEntity<List<OrderDto>> getOrdersByPhoneNumber(@PathVariable String phoneNumber) {
        List<OrderDto> orders = orderEndpoint.getAllByPhoneNumber(phoneNumber);
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/orders/address/{address}")
    public ResponseEntity<List<OrderDto>> getOrdersByAddress(@PathVariable String address) {
        List<OrderDto> orders = orderEndpoint.getAllByAddress(address);
        return ResponseEntity.ok(orders);
    }

    @PutMapping("/orders/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderRequest orderRequest) {
        try {
            OrderDto updatedOrder = orderEndpoint.update(id, orderRequest);
            return ResponseEntity.ok(updatedOrder);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PatchMapping("/orders/{id}/confirm")
    public ResponseEntity<OrderDto> confirmOrder(@PathVariable Long id) {
        try {
            OrderDto confirmedOrder = orderEndpoint.setConfirmed(id);
            return ResponseEntity.ok(confirmedOrder);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        try {
            orderEndpoint.delete(id);
            return ResponseEntity.noContent().build();
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
