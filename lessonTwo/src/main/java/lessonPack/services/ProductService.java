package lessonPack.services;

import lessonPack.domain.Product;

import java.util.List;

public interface ProductService {
    Product get(Long id);
    List<Product> getAll();
    void save(Product author);
    void remove(Product author);
}
