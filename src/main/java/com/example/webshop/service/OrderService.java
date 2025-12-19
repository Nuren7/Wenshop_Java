package com.example.webshop.service;

import com.example.webshop.exception.ProductNotFoundException;
import com.example.webshop.model.Order;
import com.example.webshop.model.OrderItem;
import com.example.webshop.model.Product;
import com.example.webshop.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, ProductService productService) {
        this.orderRepository = orderRepository;
        this.productService = productService;
    }

    public Order createOrder(Order order) {
        // Validerar produkter och uppdaterar priceAtPurchase
        double totalAmount = 0;

        for (OrderItem item : order.getItems()) {
            Product product = productService.getProductById(item.getProductId());

            // Validerar lager (om du vill kan du lägga till stock minskning här)
            if (item.getQuantity() > product.getStock()) {
                throw new IllegalArgumentException(
                        "Not enough stock for product " + product.getName()
                );
            }

            // Sätt pris vid köp
            item.setPriceAtPurchase(product.getPrice());

            // Beräkna total
            totalAmount += product.getPrice() * item.getQuantity();
        }

        order.setTotalAmount(totalAmount);
        order.setOrderDate(LocalDateTime.now());

        // Spara order
        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order with id " + id + " not found"));
    }
}
