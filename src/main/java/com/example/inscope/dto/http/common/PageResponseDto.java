package com.example.inscope.dto.http.common;

import lombok.Data;

import java.util.Collection;

@Data
public class PageResponseDto<T> {
  private Integer page;
  private Integer numberOfElements;
  private Integer totalPages;
  private Integer totalElements;
  private Collection<T> content;
}
