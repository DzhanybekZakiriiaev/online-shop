package com.example.inscope.dto.http.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateProductRequestDto {

  @NotBlank
  @ApiModelProperty(required = true)
  @Size(min = 1, max = 255)
  private String name;

  @ApiModelProperty(required = true)
  private String description;

  @ApiModelProperty(required = true)
  private Long price;

}
