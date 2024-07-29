package com.example.inscope.controller.product;

import com.example.inscope.dto.http.common.PageResponseDto;
import com.example.inscope.dto.http.product.AddProductRequestDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.dto.http.product.UpdateProductRequestDto;
import com.example.inscope.dto.http.product.paging.ProductSearchRequestDto;
import com.example.inscope.endpoint.product.ProductEndpoint;
import com.example.inscope.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductEndpoint productEndpoint;

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProduct(@PathVariable Long id) {
        try {
            ProductDto productDto = productEndpoint.get(id);
            return ResponseEntity.ok(productDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<Collection<ProductDto>> getAllProducts() {
        try {
            Collection<ProductDto> productsDto = productEndpoint.getAll();
            return ResponseEntity.ok(productsDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/search")
    public ResponseEntity<PageResponseDto<ProductDto>> searchProducts(@RequestBody ProductSearchRequestDto requestDto) {
        try {
            PageResponseDto<ProductDto> pageResponseDto = productEndpoint.search(requestDto);
            return ResponseEntity.ok(pageResponseDto);
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
