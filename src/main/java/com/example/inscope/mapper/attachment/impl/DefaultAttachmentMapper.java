package com.example.inscope.mapper.attachment.impl;

import com.example.inscope.domain.attachment.Attachment;
import com.example.inscope.dto.http.attachment.AttachmentDto;
import com.example.inscope.mapper.attachment.AttachmentMapper;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultAttachmentMapper implements AttachmentMapper {

    @Override
    @Transactional(readOnly = true)
    public Attachment toAttachmentEntity(MultipartFile file) {
        Attachment attachment = new Attachment();
        try {
            String fileName = StringUtils.cleanPath(file.getOriginalFilename());
            attachment.setName(fileName);
            attachment.setContentType(file.getContentType());
            attachment.setContent(file.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
        return attachment;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Attachment> toAttachmentEntity(List<MultipartFile> files){
        List<Attachment> attachments = new ArrayList<>();
        for(MultipartFile file : files){
            attachments.add(toAttachmentEntity(file));
        }
        return attachments;
    }

    @Override
    @Transactional(readOnly = true)
    public AttachmentDto toDto(Attachment attachment) {
        return AttachmentDto.builder()
                .name(attachment.getName())
                .content(Base64.getEncoder().encodeToString(attachment.getContent()))
                .contentType(attachment.getContentType())
                .size(attachment.getContent().length)
                .build();
    }


    @Override
    @Transactional(readOnly = true)
    public Collection<AttachmentDto> toDto(Collection<Attachment> attachments) {
        Collection<AttachmentDto> attachmentDtos = new ArrayList<>();
        for(Attachment attachment : attachments){
            attachmentDtos.add(toDto(attachment));
        }
        return attachmentDtos;
    }
}
