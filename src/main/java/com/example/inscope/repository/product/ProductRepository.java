package com.example.inscope.repository.product;

import com.example.inscope.domain.product.Product;
import com.example.inscope.repository.common.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    Product findByName(String name);

    List<Product> findAllByPrice(Long price);
}
