package com.example.inscope.controller.attachment;

import com.example.inscope.dto.http.attachment.AttachmentDto;
import com.example.inscope.endpoint.attachment.AttachmentEndpoint;
import com.example.inscope.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/attachments")
@RequiredArgsConstructor
public class AttachmentController {

    private final AttachmentEndpoint attachmentEndpoint;

    @GetMapping("/{id}")
    public ResponseEntity<AttachmentDto> getAttachment(@PathVariable Long id) {
        try {
            AttachmentDto attachmentDto = attachmentEndpoint.get(id);
            return ResponseEntity.ok(attachmentDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<AttachmentDto>> getAttachmentsByProductId(@PathVariable Long productId) {
        try {
            List<AttachmentDto> attachments = attachmentEndpoint.getAttachmentsByProductId(productId);
            return ResponseEntity.ok(attachments);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
