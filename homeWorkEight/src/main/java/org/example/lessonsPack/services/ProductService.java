package org.example.lessonsPack.services;

import org.example.lessonsPack.dao.ProductDao;
import org.example.lessonsPack.domain.Product;

import java.util.List;

public interface ProductService{
    List<Product> getAll();
    Product getById(Long id);
    Product save(Product product);
    Product update(Product firstProduct, Product innerProduct);
    Product getProductByTitle(String title);
    void deleteById(Long id);
    void deleteByProduct(Product product);
    boolean contains(Product product);
    boolean contains(Long id);
}
