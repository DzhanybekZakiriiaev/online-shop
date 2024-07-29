package com.example.inscope.dto.http.order;

import com.example.inscope.dto.http.product.ProductDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;

    private boolean isConfirmed;

    private String description;

    private ProductDto productDto;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime confirmedAt;
}
