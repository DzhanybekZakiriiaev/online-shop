package com.example.inscope.service.product;

import com.example.inscope.domain.product.Product;
import com.example.inscope.domain.product.paging.ProductSearchRequest;
import com.example.inscope.exception.NotFoundException;
import com.example.inscope.service.common.BaseService;
import org.springframework.data.domain.Page;

import java.util.Collection;
import java.util.List;

public interface ProductService extends BaseService<Product, Long> {

    Page<Product> search(ProductSearchRequest request);

    Product getByName(String name) throws NotFoundException;

    List<Product> getAllByPrice(Long price) throws NotFoundException;

    Collection<Product> getAll();

}
