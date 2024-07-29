package com.example.inscope.domain.order.paging;

import com.example.inscope.domain.paging.sorting.SortProvider;
import com.querydsl.core.types.OrderSpecifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.querydsl.QSort;

import static com.example.inscope.domain.order.QOrder.order;
public enum OrderSort implements SortProvider {
    ID {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), order.id));
        }
    },
    SURNAME {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), order.surname));
        }
    }, CREATED_DATE {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), order.createdAt));
        }
    }, CONFIRMED_DATE {
        @Override
        public Sort getSorting(Sort.Direction direction) {
            return new QSort(new OrderSpecifier<>(directionToOrder(direction), order.confirmedAt));
        }
    },
}
