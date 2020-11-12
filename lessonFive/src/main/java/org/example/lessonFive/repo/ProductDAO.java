package org.example.lessonFive.repo;

import org.example.lessonFive.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductDAO extends JpaRepository<Product, Long> {
    List<Product> findAllByCostBetween(Double start, Double end);
}
