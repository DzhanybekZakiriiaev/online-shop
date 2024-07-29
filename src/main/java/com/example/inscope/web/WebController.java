package com.example.inscope.web;

import com.example.inscope.dto.http.product.ProductDetailedDto;
import com.example.inscope.dto.http.product.ProductDto;
import com.example.inscope.endpoint.product.ProductEndpoint;
import com.example.inscope.exception.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@AllArgsConstructor
@RequestMapping("/")
public class WebController {

    private final ProductEndpoint productEndpoint;

    // Main Page displaying products
    @GetMapping
    public String mainPage(Model model) throws NotFoundException {
        Collection<ProductDto> products = productEndpoint.getAll();
        model.addAttribute("products", products);
        return "main";
    }

    @GetMapping("/{id}")
    public String productDetailPage(@PathVariable Long id, Model model) throws NotFoundException {
        ProductDetailedDto product = productEndpoint.getDetailed(id);
        model.addAttribute("product", product);
        return "product";
    }
}

