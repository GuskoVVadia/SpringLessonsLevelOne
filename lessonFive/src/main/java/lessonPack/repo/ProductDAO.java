package lessonPack.repo;

import lessonPack.domain.Product;

import java.util.List;

public interface ProductDAO {
    List<Product> findAll();
    Product fundById(Long id);
    void save(Product product);
    void update(Product product);
    void delete(Product product);
}
