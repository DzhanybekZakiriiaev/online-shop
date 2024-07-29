package com.example.inscope.domain.paging;

import com.example.inscope.domain.paging.sorting.SortInfo;
import com.example.inscope.domain.paging.sorting.SortProvider;

import lombok.Data;

@Data
public class PageRequestBase<T extends SortProvider> {
  private PageInfo pageInfo;

  private SortInfo<T> sortInfo;
}
