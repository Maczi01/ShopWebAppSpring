package com.mati.springshop.order;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class HashMapOrderRepository implements OrderRepository {

    private Map<Long, Order> orders = new HashMap<>();
    private long index = 0;

    @Override
    public Order save(Order odder) {
        odder.setId(++index);
        orders.put(index, odder);
        return odder;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public void update(Order order) {
        orders.replace(order.getId(), order);
    }
}
