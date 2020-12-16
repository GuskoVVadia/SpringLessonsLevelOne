package org.example.lessonsPack.dao;

import org.example.lessonsPack.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDao extends JpaRepository<Product, Long> {
    Product getProductByTitle(String title);
}
