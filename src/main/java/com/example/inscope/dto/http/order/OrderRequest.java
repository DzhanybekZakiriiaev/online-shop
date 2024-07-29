package com.example.inscope.dto.http.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;

    private Long productId;

    private String description;

}
