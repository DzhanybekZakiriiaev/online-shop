package com.example.inscope.dto.http.order.paging;

import lombok.Data;

import java.time.LocalDate;


@Data
public class OrderFilterRequestDto {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;

    private boolean isConfirmed;

    private LocalDate createdDateFrom;

    private LocalDate createdDateTo;

    private LocalDate confirmedDateFrom;

    private LocalDate confirmedDateTo;
}
