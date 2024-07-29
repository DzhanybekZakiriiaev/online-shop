package com.example.inscope.dto.http.common;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Collection;

@Data
@AllArgsConstructor
public class CollectionResponseDto<T> {
  private Collection<T> data;
}
