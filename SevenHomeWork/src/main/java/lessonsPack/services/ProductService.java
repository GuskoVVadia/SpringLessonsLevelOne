package lessonsPack.services;

import lessonsPack.domain.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getById(Long id);
    Product save(Product product);
    Product update(Product product);
    void deleteById(Long id);
    void deleteByProduct(Product product);
    boolean contains(Product product);
    boolean contains(Long id);
}
