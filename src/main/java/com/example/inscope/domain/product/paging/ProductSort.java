package com.example.inscope.domain.product.paging;

import com.example.inscope.domain.paging.sorting.SortProvider;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;

import static com.example.inscope.domain.product.QProduct.product;
public enum ProductSort implements SortProvider {
    ID {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), product.id));
        }
    },
    DESCRIPTION {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), product.description));
        }
    }, DATE {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), product.createdAt));
        }
    },
}
