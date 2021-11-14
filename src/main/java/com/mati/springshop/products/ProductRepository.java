package com.mati.springshop.products;

import com.mati.springshop.common.PagedResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product save(Product product);

    PagedResult<Product> findAll(int pageNumber, int pageSize);


}
