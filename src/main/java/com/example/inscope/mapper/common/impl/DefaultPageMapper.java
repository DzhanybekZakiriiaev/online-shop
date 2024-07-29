package com.example.inscope.mapper.common.impl;

import com.example.inscope.domain.common.BaseEntity;
import com.example.inscope.dto.http.common.PageResponseDto;
import com.example.inscope.mapper.common.PageMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
class DefaultPageMapper implements PageMapper {

  @Override
  public <M extends BaseEntity, D> PageResponseDto<D> toPageResponse(
      Page<M> page, Collection<D> content) {
    var dto = new PageResponseDto<D>();

    dto.setPage(page.getPageable().getPageNumber());
    dto.setTotalPages(page.getTotalPages());
    dto.setNumberOfElements(page.getNumberOfElements());

    Integer totalElements = Long.valueOf(page.getTotalElements()).intValue();
    dto.setTotalElements(totalElements);

    dto.setContent(content);

    return dto;
  }
}
