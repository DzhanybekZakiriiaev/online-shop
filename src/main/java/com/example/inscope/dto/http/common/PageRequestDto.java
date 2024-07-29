package com.example.inscope.dto.http.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDto {

  @Min(0)
  private Integer page = 0;

  @Min(0)
  @Max(MAX_LIMIT)
  private Integer limit = DEFAULT_LIMIT;

  @JsonIgnore private static final int MAX_LIMIT = 100;

  @JsonIgnore private static final int DEFAULT_LIMIT = 25;
}
