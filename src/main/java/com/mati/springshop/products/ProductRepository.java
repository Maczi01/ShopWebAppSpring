package com.mati.springshop.products;

import com.mati.springshop.common.PagedResult;

public interface ProductRepository {

    Product save(Product product);

    PagedResult<Product> findAll(int pageNumber, int pageSize);


}
