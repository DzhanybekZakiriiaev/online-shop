package com.example.inscope.repository.attachment;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AttachmentRepository extends BaseRepository<Attachment> {
    List<Attachment> findAllByProductId(Long productId);

    Optional<Attachment> findTopByProductIdOrderByCreatedAtAsc(Long productId);
}
