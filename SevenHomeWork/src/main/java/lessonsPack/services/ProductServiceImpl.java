package lessonsPack.services;

import lessonsPack.dao.ProductDao;
import lessonsPack.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
//        this.productDao.save(new Product("milk", 25.5));
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
    public void deleteById(Long id) {
        this.productDao.deleteById(id);
    }

    @Override
    public void deleteByProduct(Product product) {
        this.productDao.delete(product);
    }

    @Override
    public Product update(Product product){
        //какая-то логика
        System.out.println("Замена продукта: " + product.toString());
        return save(product);
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
