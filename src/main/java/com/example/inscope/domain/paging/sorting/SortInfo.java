package com.example.inscope.domain.paging.sorting;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SortInfo<T extends SortProvider> {
  private T sortBy;
  private Sort.Direction sortDirection;
}
