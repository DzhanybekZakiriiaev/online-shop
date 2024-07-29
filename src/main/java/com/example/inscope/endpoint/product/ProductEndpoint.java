package com.example.inscope.endpoint.product;

import com.example.inscope.dto.http.common.PageResponseDto;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDetailedDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface ProductEndpoint {

    PageResponseDto<ProductDto> search(ProductSearchRequestDto requestDto) throws NotFoundException;

    ProductDto get(Long id) throws NotFoundException;

    ProductDetailedDto getDetailed(Long id) throws NotFoundException;

    Collection<ProductDto> getAll() throws NotFoundException;

    ProductDto add(AddProductRequestDto requestDto, List<MultipartFile> attachments) throws NotFoundException;

    ProductDto update(Long id, UpdateProductRequestDto requestDto) throws NotFoundException;

    void delete(Long id) throws NotFoundException;
}
