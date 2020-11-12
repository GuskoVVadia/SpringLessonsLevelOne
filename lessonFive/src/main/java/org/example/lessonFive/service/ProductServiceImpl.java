package org.example.lessonFive.service;

import org.example.lessonFive.domain.Product;
import org.example.lessonFive.repo.ProductDAO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;

    public ProductServiceImpl(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @Override
    public List<Product> getAll() {
        return productDAO.findAll();
    }

    @Override
    public Product getById(Long id) {
        return productDAO.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return productDAO.save(product);
    }

    @Override
    public List<Product> getByPrice(double priceFrom, double priceTo) {
        return productDAO.findAllByCostBetween(priceFrom, priceTo);
    }
}
