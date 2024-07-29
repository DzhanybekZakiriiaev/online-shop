package com.example.inscope.service.product.impl;

import com.example.inscope.domain.product.Product;
import com.example.inscope.domain.product.paging.ProductFilterRequest;
import com.example.inscope.domain.product.paging.ProductSearchRequest;
import com.example.inscope.repository.product.ProductRepository;
import com.example.inscope.service.common.impl.DefaultBaseService;
import com.example.inscope.service.product.ProductService;
import com.querydsl.core.BooleanBuilder;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;

import static com.example.inscope.domain.product.QProduct.product;
import static java.util.Objects.nonNull;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DefaultProductService extends DefaultBaseService<Product, Long> implements ProductService {

    ProductRepository repository;

    public DefaultProductService(@Qualifier("productRepository") CrudRepository<Product, Long> crudRepository,
                                 ProductRepository repository) {
        super(crudRepository);
        this.repository = repository;
    }


    @Override
    @Transactional(readOnly = true)
    public Page<Product> search(ProductSearchRequest request) {
        BooleanBuilder predicate = new BooleanBuilder();
        ProductFilterRequest filter = request.getFilterRequest();

        search(predicate, filter);
        return repository.findAll(predicate, request.getPageRequest());
    }

    @Override
    @Transactional(readOnly = true)
    public Product getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Product> getAllByPrice(Long price) {
        return repository.findAllByPrice(price);
    }

    @Override
    public Collection<Product> getAll() {
        return repository.findAll();
    }

    private void search(BooleanBuilder predicate, ProductFilterRequest filter) {
        if (nonNull(filter.getId())) {
            predicate.and(product.id.eq(filter.getId()));
        }
        if (nonNull(filter.getDescription())) {
            predicate.and(product.description.contains(filter.getDescription()));
        }
        if (nonNull(filter.getName())) {
            predicate.and(product.name.contains(filter.getName()));
        }
        if (nonNull(filter.getPrice())) {
            predicate.and(product.price.eq(filter.getPrice()));
        }
        if (nonNull(filter.getCreatedDateFrom())) {
            predicate.and(product.createdAt.goe(filter.getCreatedDateFrom()));
        }
        if (nonNull(filter.getCreatedDateTo())) {
            predicate.and(product.createdAt.loe(filter.getCreatedDateTo().toLocalDate().atTime(LocalTime.MAX)));
        }

    }
}
