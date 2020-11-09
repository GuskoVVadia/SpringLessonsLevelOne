package lessonPack.services;

import lessonPack.InitData;
import lessonPack.domain.Product;
import lessonPack.repository.ProductJpaDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductJpaDAO productJpaDAO;

    @Override
    public Product addProduct(Product product) {
        Product saveProduct = productJpaDAO.saveAndFlush(product);
        return saveProduct;
    }

    @Override
    @Transactional(readOnly = true)
    public Product get(Long id) {
        return this.productJpaDAO.getOne(id);
    }

    @Override
    @Transactional
    public void save(Product product) {
        this.productJpaDAO.save(product);
    }

    @Override
    @Transactional
    public void remove(Product product) {
        this.productJpaDAO.delete(product);
    }

    @Override
    public List<Product> getAll(){
        return this.productJpaDAO.findAll();
    }

    @Transactional
    public List<Product> sortByMinAll(){
        return this.productJpaDAO.findAll();
    }
}
