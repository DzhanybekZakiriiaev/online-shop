package com.example.inscope.endpoint.attachment.impl;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.domain.product.Product;
import com.example.inscope.dto.http.attachment.AttachmentDto;
import com.example.inscope.endpoint.attachment.AttachmentEndpoint;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.mapper.attachment.AttachmentMapper;
import com.example.inscope.service.attachment.AttachmentService;
import com.example.inscope.service.product.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultAttachmentEndpoint implements AttachmentEndpoint {

    AttachmentMapper attachmentMapper;
    AttachmentService attachmentService;

    ProductService productService;

    @Override
    @Transactional(readOnly = true)
    public AttachmentDto get(Long id) throws NotFoundException {
        Attachment attachment = attachmentService.get(id);
        return attachmentMapper.toDto(attachment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AttachmentDto> getAttachmentsByProductId(Long productId) throws NotFoundException {
        List<Attachment> attachments = attachmentService.getAllByProductId(productId);
        if (attachments.isEmpty()) {
            throw new NotFoundException("No attachments found for product ID: " + productId);
        }
        return attachments.stream()
                .map(attachmentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public AttachmentDto uploadAttachment(MultipartFile file, Long productId) throws IOException, NotFoundException {
        Product product = productService.get(productId);
        Attachment attachment = attachmentService.storeAttachment(file, product);
        return attachmentMapper.toDto(attachment);
    }

    @Override
    @Transactional(readOnly = true)
    public AttachmentDto getFirstAttachmentByProductId(Long productId) {
        return attachmentService.findTop(productId)
                .map(attachmentMapper::toDto)
                .orElse(null);
    }
}
