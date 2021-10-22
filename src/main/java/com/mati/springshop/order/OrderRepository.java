package com.mati.springshop.order;

import java.util.Optional;

public interface OrderRepository {

    Order save(Order odder);

    Optional<Order> findById(Long id);

    void update(Order order);

}
