package com.example.inscope.repository.common;

import com.example.inscope.domain.paging.PageInfo;
import com.example.inscope.domain.paging.PageRequestBase;
import com.google.common.collect.Lists;
import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Objects;

@NoRepositoryBean
public interface BaseRepository<T> extends JpaRepository<T, Long>, QuerydslPredicateExecutor<T> {

  default Page<T> findAll(Predicate predicate, PageRequestBase<?> pageRequest) {
    Sort sort = Objects.nonNull(pageRequest.getSortInfo()) ? getSort(pageRequest) : Sort.unsorted();
    PageInfo pageInfo = pageRequest.getPageInfo();

    if (Objects.nonNull(pageInfo)) {
      PageRequest page = PageRequest.of(pageInfo.getPage(), pageInfo.getLimit(), sort);

      return findAll(predicate, page);
    }

    List<T> s = Lists.newArrayList(findAll(predicate, sort));
    return new PageImpl<>(s);
  }

  default Page<T> findAll(PageRequestBase<?> pageRequest) {
    Sort sort = getSort(pageRequest);
    PageInfo pageInfo = pageRequest.getPageInfo();

    if (Objects.nonNull(pageInfo)) {
      PageRequest page = PageRequest.of(pageInfo.getPage() - 1, pageInfo.getLimit(), sort);
      return findAll(page);
    }

    List<T> s = Lists.newArrayList(findAll(sort));
    return new PageImpl<>(s);
  }

  private Sort getSort(PageRequestBase<?> pageRequest) {
    Sort.Direction sortDirection = pageRequest.getSortInfo().getSortDirection();
    return pageRequest.getSortInfo().getSortBy().getSorting(sortDirection);
  }
}
