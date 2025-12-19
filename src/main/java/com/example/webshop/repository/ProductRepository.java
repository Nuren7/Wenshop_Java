package com.example.webshop.repository;

import com.example.webshop.model.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ProductRepository {

    private final List<Product> products = new ArrayList<>();

    public ProductRepository() {
        // Exempelprodukter (seed data)
        products.add(new Product(
                1L,
                "Laptop",
                "Bärbar dator för arbete och studier",
                9999.0,
                10
        ));

        products.add(new Product(
                2L,
                "Mobiltelefon",
                "Smartphone med bra kamera",
                5999.0,
                15
        ));

        products.add(new Product(
                3L,
                "Hörlurar",
                "Trådlösa hörlurar",
                1999.0,
                20
        ));
    }

    public List<Product> findAll() {
        return products;
    }

    public Optional<Product> findById(long id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }
}
