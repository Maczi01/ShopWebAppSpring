package com.mati.springshop;

import com.mati.springshop.order.Order;
import com.mati.springshop.payments.*;
import com.mati.springshop.products.Product;
import com.mati.springshop.products.ProductService;
import com.mati.springshop.products.ProductsType;
import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

//@SpringBootApplication
@Log
public class SpringShopApplication {


    public static final Product VIDEO_PRODUCT = Product
            .builder()
            .name("Camera")
            .description("Camera full hd")
            .type(ProductsType.VIDEO)
            .price(LocalMoney.of(1000))
            .build();

    public static final Product BOOK_PRODUCT = Product
            .builder()
            .name("Harry Potter")
            .description("About young boy")
            .type(ProductsType.BOOK)
            .price(LocalMoney.of(50))
            .build();

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("com.mati.springshop")) {
            var shopService = annotationConfigApplicationContext.getBean(ShopService.class);
            shopService.addProduct(VIDEO_PRODUCT);
            shopService.addProduct(BOOK_PRODUCT);
            log.info(shopService.getProducts(0, 100).toString());

            var order = new Order(List.of(VIDEO_PRODUCT, BOOK_PRODUCT));
            shopService.placeOrder(order);
            var payment = shopService.payForOrder(order.getId());
            shopService.payForOrder(order.getId());
            log.info(payment.getId());
        }

    }

}
