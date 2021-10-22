package com.mati.springshop.order;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public Order add(Order order) {
        return orderRepository.save(order);
    }

    public Order getById(Long id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    public void update(Order order) {
        orderRepository.save(order);
    }
}
