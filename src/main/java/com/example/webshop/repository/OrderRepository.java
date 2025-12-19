package com.example.webshop.repository;

import com.example.webshop.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class OrderRepository {

    private final List<Order> orders = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong(1);

    // Spara order och generera id
    public Order save(Order order) {
        long id = idGenerator.getAndIncrement();
        order.setId(id);
        orders.add(order);
        return order;
    }

    // Hämta alla ordrar
    public List<Order> findAll() {
        return orders;
    }

    // Hämta order med specifikt id
    public Optional<Order> findById(long id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }
}
