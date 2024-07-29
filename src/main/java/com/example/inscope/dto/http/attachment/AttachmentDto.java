package com.example.inscope.dto.http.attachment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Base64;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttachmentDto {

    private String name;

    private String content;

    private String contentType;

    private long size;

    public void setContent(byte[] content) {
        this.content = Base64.getEncoder().encodeToString(content);
    }
}

