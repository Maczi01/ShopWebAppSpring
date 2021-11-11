package com.mati.springshop.order;

import lombok.Setter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

public class JpaOrderRepository  implements OrderRepository {

    @Setter
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public Order save(Order odder) {
        return null;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void update(Order order) {

    }
}
