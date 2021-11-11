package com.mati.springshop.products;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

public class ProductsConfiguration {

    @Bean
    public ProductRepository productRepository(SessionFactory sessionFactory) {
        return new HibernateProductRepository(sessionFactory);
    }

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
