package com.example.inscope.mapper.product;

import com.example.inscope.domain.product.Product;
import com.example.inscope.domain.product.paging.ProductSearchRequest;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDetailedDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ProductMapper {

    ProductDto toDto(Product product);

    ProductDetailedDto toDetailedDto(Product product) throws NotFoundException;

    Collection<ProductDto> toDto(Collection<Product> products);

    Product toProduct(AddProductRequestDto requestDto) throws NotFoundException;

    Product toProduct(UpdateProductRequestDto requestDto, Product product) throws NotFoundException;

    ProductSearchRequest toSearchRequest(ProductSearchRequestDto requestDto) throws NotFoundException;

}
