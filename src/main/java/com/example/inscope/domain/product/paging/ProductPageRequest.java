package com.example.inscope.domain.product.paging;

import com.example.inscope.domain.paging.PageInfo;
import com.example.inscope.domain.paging.PageRequestBase;
import com.example.inscope.domain.paging.sorting.SortInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductPageRequest extends PageRequestBase<ProductSort> {
    private PageInfo pageInfo;
    private SortInfo<ProductSort> sortInfo;
}
