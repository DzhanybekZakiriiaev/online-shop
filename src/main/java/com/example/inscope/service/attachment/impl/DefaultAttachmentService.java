package com.example.inscope.service.attachment.impl;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.domain.product.Product;
import com.example.inscope.mapper.attachment.AttachmentMapper;
import com.example.inscope.repository.attachment.AttachmentRepository;
import com.example.inscope.service.attachment.AttachmentService;
import com.example.inscope.service.common.impl.DefaultBaseService;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultAttachmentService extends DefaultBaseService<Attachment, Long> implements AttachmentService {

    AttachmentRepository repository;

    AttachmentMapper mapper;

    public DefaultAttachmentService(@Qualifier("attachmentRepository") CrudRepository<Attachment, Long> crudRepository,
                                    AttachmentRepository repository, AttachmentMapper mapper) {
        super(crudRepository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Attachment> getAllByProductId(Long productId) {
        return repository.findAllByProductId(productId);
    }

    @Override
    public Optional<Attachment> findTop(Long productId) {
        return repository.findTopByProductIdOrderByCreatedAtAsc(productId);
    }

    @Override
    public Attachment getAttachment(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Attachment not found"));
    }

    @Override
    public List<Attachment> getAllAttachments() {
        return repository.findAll();
    }

    @Override
    public Attachment storeAttachment(MultipartFile file, Product product) throws IOException {
        Attachment attachment = mapper.toAttachmentEntity(file);
        attachment.setProduct(product);
        return repository.save(attachment);
    }
}
