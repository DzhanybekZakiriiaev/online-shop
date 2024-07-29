package com.example.inscope.endpoint.attachment;

import com.example.inscope.dto.http.attachment.AttachmentDto;
import com.example.inscope.exception.NotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AttachmentEndpoint {
    @Transactional(readOnly = true)
    AttachmentDto get(Long id) throws NotFoundException;

    @Transactional(readOnly = true)
    List<AttachmentDto> getAttachmentsByProductId(Long productId) throws NotFoundException;

    @Transactional
    AttachmentDto uploadAttachment(MultipartFile file, Long productId) throws IOException, NotFoundException;

    @Transactional(readOnly = true)
    AttachmentDto getFirstAttachmentByProductId(Long productId);
}
