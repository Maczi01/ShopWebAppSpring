package com.mati.springshop.products;

import com.mati.springshop.common.PagedResult;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapProductRepository implements ProductRepository {

    private HashMap<Long, Product> productHashMap = new HashMap<>();
    private long index = 0;


    @Override
    public Product save(Product product) {
        product.setId(++index);
        productHashMap.put(index, product);
        return product;
    }

    @Override
    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        var totalPages = (int) Math.ceil((double) productHashMap.size() / pageSize);
        var data = new ArrayList<>(productHashMap.values());
        return new PagedResult<>(data, pageNumber, totalPages);
    }
}
