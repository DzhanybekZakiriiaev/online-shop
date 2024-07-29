package com.example.inscope.mapper.common;

import com.example.inscope.domain.common.BaseEntity;

import com.example.inscope.dto.http.common.PageResponseDto;
import org.springframework.data.domain.Page;

import java.util.Collection;

public interface PageMapper {
  <M extends BaseEntity, D> PageResponseDto<D> toPageResponse(Page<M> page, Collection<D> content);
}
