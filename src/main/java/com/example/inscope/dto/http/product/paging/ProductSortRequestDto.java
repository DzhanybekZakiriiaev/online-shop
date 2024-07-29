package com.example.inscope.dto.http.product.paging;



import com.example.inscope.domain.product.paging.ProductSort;
import com.example.inscope.dto.http.common.SortRequestDtoBase;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Sort;

@AllArgsConstructor
@NoArgsConstructor
public class ProductSortRequestDto implements SortRequestDtoBase<ProductSort> {

    private ProductSort sortBy = ProductSort.ID;
    private Sort.Direction sortDirection = Sort.Direction.ASC;

    @Override
    public ProductSort getSortBy() {
        return sortBy;
    }

    @Override
    public void setSortBy(ProductSort sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public Sort.Direction setSortDirection() {
        return sortDirection;
    }

    @Override
    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }
}
