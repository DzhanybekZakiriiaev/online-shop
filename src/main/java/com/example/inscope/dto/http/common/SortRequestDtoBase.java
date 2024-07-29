package com.example.inscope.dto.http.common;

import com.example.inscope.domain.paging.sorting.SortProvider;
import org.springframework.data.domain.Sort;

public interface SortRequestDtoBase<T extends SortProvider> {

  T getSortBy();

  void setSortBy(T sortBy);

  Sort.Direction setSortDirection();

  void setSortDirection(Sort.Direction sortDirection);
}
