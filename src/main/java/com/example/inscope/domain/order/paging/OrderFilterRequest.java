package com.example.inscope.domain.order.paging;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderFilterRequest {

    private Long id;

    private String name;

    private String surname;

    private String email;

    private String phoneNumber;

    private String address;

    private boolean isConfirmed;

    private LocalDateTime createdDateFrom;

    private LocalDateTime createdDateTo;

    private LocalDateTime confirmedDateFrom;

    private LocalDateTime confirmedDateTo;
}
