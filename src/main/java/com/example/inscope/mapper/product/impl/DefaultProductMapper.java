package com.example.inscope.mapper.product.impl;

import com.example.inscope.domain.paging.PageInfo;
import com.example.inscope.domain.paging.sorting.SortInfo;
import com.example.inscope.domain.product.Product;
import com.example.inscope.domain.product.paging.ProductFilterRequest;
import com.example.inscope.domain.product.paging.ProductPageRequest;
import com.example.inscope.domain.product.paging.ProductSearchRequest;
import com.example.inscope.domain.product.paging.ProductSort;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDetailedDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductFilterRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.endpoint.attachment.AttachmentEndpoint;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.mapper.attachment.AttachmentMapper;
import com.example.inscope.mapper.product.ProductMapper;
import com.example.inscope.service.attachment.AttachmentService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultProductMapper implements ProductMapper {

    private final AttachmentEndpoint attachmentEndpoint;

    @Override
    @Transactional(readOnly = true)
    public ProductDetailedDto toDetailedDto(Product product) throws NotFoundException {
        return ProductDetailedDto.builder()
                .id(product.getId())
                .name(product.getName())
                .model(product.getModel())
                .priceOpt(product.getPriceOpt())
                .priceAdvance(product.getPriceAdvance())
                .price(product.getPrice())
                .description(product.getDescription())
                .attachmentDtos(attachmentEndpoint.getAttachmentsByProductId(product.getId()))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto toDto(Product product) {
        return ProductDto.builder()
                .id(product.getId())
                .name(product.getName())
                .model(product.getModel())
                .price(product.getPrice())
                .description(product.getDescription())
                .firstAttachment(attachmentEndpoint.getFirstAttachmentByProductId(product.getId()))
                .build();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ProductDto> toDto(Collection<Product> products) {
        Collection<ProductDto> dtos = new ArrayList<>();
        for (Product product : products) {
            dtos.add(toDto(product));
        }
        return dtos;
    }

    @Override
    @Transactional(readOnly = true)
    public Product toProduct(AddProductRequestDto requestDto) throws NotFoundException {
        Product product = new Product();
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public Product toProduct(UpdateProductRequestDto requestDto, Product product) throws NotFoundException {
        product.setName(requestDto.getName());
        product.setDescription(requestDto.getDescription());
        product.setPrice(requestDto.getPrice());
        return product;
    }

    @Override
    @Transactional(readOnly = true)
    public ProductSearchRequest toSearchRequest(ProductSearchRequestDto requestDto) throws NotFoundException {
        ProductPageRequest pageRequest = toPageRequest(requestDto);
        ProductFilterRequest filter = toFilterRequest(requestDto.getFilter());

        return ProductSearchRequest.builder().pageRequest(pageRequest).filterRequest(filter).build();
    }

    private ProductPageRequest toPageRequest(ProductSearchRequestDto requestDto) {
        PageInfo pageInfo = new PageInfo(requestDto.getPageRequest().getPage(), requestDto.getPageRequest().getLimit());

        SortInfo<ProductSort> sortInfo = new SortInfo<>(requestDto.getSorting().getSortBy(), requestDto.getSorting().setSortDirection());

        return new ProductPageRequest(pageInfo, sortInfo);
    }

    private ProductFilterRequest toFilterRequest(ProductFilterRequestDto requestDto) throws NotFoundException {
        ProductFilterRequest filterRequest = new ProductFilterRequest();

        if (Objects.isNull(requestDto))
            return filterRequest;

        if (nonNull(requestDto.getId()))
            filterRequest.setId(requestDto.getId());

        if (nonNull(requestDto.getName()))
            filterRequest.setName(requestDto.getName());

        if (nonNull(requestDto.getDescription()))
            filterRequest.setDescription(requestDto.getDescription());

        if (nonNull(requestDto.getPrice()))
            filterRequest.setPrice(requestDto.getPrice());

        if (nonNull(requestDto.getCreatedDateFrom()))
            filterRequest.setCreatedDateFrom(requestDto.getCreatedDateFrom().atStartOfDay());

        if (nonNull(requestDto.getCreatedDateTo()))
            filterRequest.setCreatedDateTo(requestDto.getCreatedDateTo().atStartOfDay());

        return filterRequest;
    }
}
