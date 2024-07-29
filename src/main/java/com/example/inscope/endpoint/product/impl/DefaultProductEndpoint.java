package com.example.inscope.endpoint.product.impl;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.domain.product.Product;
import com.example.inscope.domain.product.paging.ProductSearchRequest;
import com.example.inscope.dto.http.common.PageResponseDto;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDetailedDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.endpoint.product.ProductEndpoint;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.mapper.attachment.AttachmentMapper;
import com.example.inscope.mapper.common.PageMapper;
import com.example.inscope.mapper.product.ProductMapper;
import com.example.inscope.service.attachment.AttachmentService;
import com.example.inscope.service.product.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultProductEndpoint implements ProductEndpoint {

    ProductMapper productMapper;
    ProductService productService;
    AttachmentService attachmentService;
    AttachmentMapper attachmentMapper;
    PageMapper pageMapper;

    @Override
    @Transactional(readOnly = true)
    public PageResponseDto<ProductDto> search(ProductSearchRequestDto requestDto) throws NotFoundException {
        ProductSearchRequest request = productMapper.toSearchRequest(requestDto);
        Page<Product> page = productService.search(request);

        Collection<ProductDto> dtos =
                page.getContent().stream()
                        .map(productMapper::toDto)
                        .collect(Collectors.toList());

        return pageMapper.toPageResponse(page, dtos);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDto get(Long id) throws NotFoundException {
        Product product = productService.get(id);
        return productMapper.toDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public ProductDetailedDto getDetailed(Long id) throws NotFoundException {
        Product product = productService.get(id);
        return productMapper.toDetailedDto(product);
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ProductDto> getAll() throws NotFoundException {
        Collection<Product> products = productService.getAll();
        return productMapper.toDto(products);
    }

    @Override
    @Transactional
    public ProductDto add(AddProductRequestDto requestDto, List<MultipartFile> attachments) throws NotFoundException {
        Product product = productMapper.toProduct(requestDto);
        productService.saveOrUpdate(product);

        List<Attachment> attachmentEntities = attachmentMapper.toAttachmentEntity(attachments);
        for (Attachment attachment : attachmentEntities) {
            attachment.setProduct(product);
            attachmentService.saveOrUpdate(attachment);
        }

        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public ProductDto update(Long id, UpdateProductRequestDto requestDto) throws NotFoundException {
        Product product = productMapper.toProduct(requestDto, productService.get(id));
        productService.saveOrUpdate(product);

        return productMapper.toDto(product);
    }

    @Override
    @Transactional
    public void delete(Long id) throws NotFoundException {
        Product product = productService.get(id);
        productService.delete(product);
    }
}
