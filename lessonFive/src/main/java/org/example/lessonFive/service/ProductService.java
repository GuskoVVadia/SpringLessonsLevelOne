package org.example.lessonFive.service;

import org.example.lessonFive.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product save(Product product);
    List<Product> getByPrice(double priceFrom, double priceTo);
}
