package com.mati.springshop.products;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;

public class ProductsConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository) {
        return new ProductService(productRepository);
    }
}
