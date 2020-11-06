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
    private ProductJpaDAO productJpaDAO;

    public ProductServiceImpl(ProductJpaDAO productJpaDAO) {
        this.productJpaDAO = productJpaDAO;
        init();
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

    @Transactional
    public void init(){
        Product product = new Product();
        product.setCost(50.2);
        product.setTitle("mil");
        productJpaDAO.save(product);

        Product product1 = new Product();
        product1.setTitle("bread");
        product1.setCost(22.0);
        productJpaDAO.save(product1);
    }
}
