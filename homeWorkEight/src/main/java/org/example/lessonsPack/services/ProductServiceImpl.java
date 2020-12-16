package org.example.lessonsPack.services;

import org.example.lessonsPack.dao.ProductDao;
import org.example.lessonsPack.domain.Product;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return this.productDao.findAll();
    }

    @Override
    public Product getById(Long id) {
        return this.productDao.findById(id).orElse(null);
    }

    @Override
    public Product save(Product product) {
        return this.productDao.saveAndFlush(product);
    }

    @Override
    public Product update(Product firstProduct, Product innerProduct) {
        if (firstProduct != null) {
            if (!innerProduct.getTitle().equals("")) {
                firstProduct.setTitle(innerProduct.getTitle());
            }
            if (innerProduct.getPrice() != null) {
                firstProduct.setPrice(innerProduct.getPrice());
            }
            return save(firstProduct);
        } else {
            return save(innerProduct);
        }
    }

    @Override
    public Product getProductByTitle(String title) {
        Product finderProduct;
        try {
            finderProduct = this.productDao.getProductByTitle(title);

        } catch (Exception e){
            System.err.println("Error find product by name: try -> catch");
            finderProduct = null;
        }
        return finderProduct;
    }

    @Override
    public void deleteById(Long id) {
        this.productDao.deleteById(id);
    }

    @Override
    public void deleteByProduct(Product product) {
        this.productDao.delete(product);
    }

    @Override
    public boolean contains(Product product) {
        return this.productDao.existsById(product.getId());
    }

    @Override
    public boolean contains(Long id) {
        return this.productDao.existsById(id);
    }
}
