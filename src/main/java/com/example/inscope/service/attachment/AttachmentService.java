package com.example.inscope.service.attachment;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.domain.product.Product;
import com.example.inscope.service.common.BaseService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface AttachmentService extends BaseService<Attachment, Long> {
    List<Attachment> getAllByProductId(Long productId);

    Optional<Attachment> findTop(Long productId);
    Attachment getAttachment(Long id);

    List<Attachment> getAllAttachments();

    Attachment storeAttachment(MultipartFile file, Product product) throws IOException;
}
