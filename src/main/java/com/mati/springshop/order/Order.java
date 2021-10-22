package com.mati.springshop.order;

import com.mati.springshop.payments.LocalMoney;
import com.mati.springshop.payments.Payment;
import com.mati.springshop.products.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.javamoney.moneta.FastMoney;

import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@Data
public class Order {

    private Long id;
    @NonNull
    private List<Product> products;
    private Payment payment;

    public FastMoney getTotalPrice() {
        return products.stream().map(Product::getPrice).reduce(LocalMoney.zero(), FastMoney::add);
    }

}
