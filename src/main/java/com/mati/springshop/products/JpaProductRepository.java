package com.mati.springshop.products;


import com.mati.springshop.common.PagedResult;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class JpaProductRepository implements ProductRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Product save(Product product) {
        entityManager.persist(product);
        entityManager.flush();
        entityManager.refresh(product);
        return product;
    }

    @Override
    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        List<Product> products = entityManager
                .createNamedQuery(Product.SELECT_PRODUCTS, Product.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return new PagedResult<>(products, pageNumber, -1);
    }
}
