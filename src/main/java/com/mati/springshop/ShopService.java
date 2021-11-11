package com.mati.springshop;

import com.mati.springshop.common.PagedResult;
import com.mati.springshop.order.Order;
import com.mati.springshop.order.OrderService;
import com.mati.springshop.payments.Payment;
import com.mati.springshop.payments.PaymentRequest;
import com.mati.springshop.payments.PaymentService;
import com.mati.springshop.products.Product;
import com.mati.springshop.products.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
public class ShopService {

    private final OrderService orderService;
    private final PaymentService paymentService;
    private final ProductService productService;

    public Product addProduct(Product product) {
        return productService.addProduct(product);
    }

    public PagedResult<Product> getProducts(int pageNumber, int pageSize) {
        return productService.getAll(pageNumber, pageSize);
    }


    public Order placeOrder(Order order) {
        return orderService.add(order);
    }

    public Payment payForOrder(long id) {
        var orderById = orderService.getById(id);
        var paymentRequest = PaymentRequest.builder()
                .money(orderById.getTotalPrice())
                .build();
        var payment = paymentService.process(paymentRequest);
        orderById.setPayment(payment);
        orderService.update(orderById);
        return payment;
    }

}
