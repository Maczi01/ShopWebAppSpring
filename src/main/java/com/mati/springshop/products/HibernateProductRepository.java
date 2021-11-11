package com.mati.springshop.products;

import com.mati.springshop.common.PagedResult;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

@RequiredArgsConstructor
public class HibernateProductRepository implements ProductRepository {

    private final SessionFactory sessionFactory;

    @Override
    public Product save(Product product) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(product);
        product.setId(id);
        return product;
    }
Ad
    @Override
    public PagedResult<Product> findAll(int pageNumber, int pageSize) {
        List<Product> products = sessionFactory.getCurrentSession()
                .createNamedQuery(Product.SELECT_PRODUCTS, Product.class)
                .setFirstResult(pageNumber * pageSize)
                .setMaxResults(pageSize)
                .getResultList();
        return new PagedResult<>(products, pageNumber, -1);
    }
}
