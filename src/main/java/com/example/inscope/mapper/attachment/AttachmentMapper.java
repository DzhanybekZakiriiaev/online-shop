package com.example.inscope.mapper.attachment;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.dto.http.attachment.AttachmentDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface AttachmentMapper {

    Attachment toAttachmentEntity(MultipartFile file);

    List<Attachment> toAttachmentEntity(List<MultipartFile> files);

    AttachmentDto toDto(Attachment attachment);

    Collection<AttachmentDto> toDto(Collection<Attachment> attachments);
}
