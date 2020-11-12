package lessonPack.service;

import lessonPack.domain.Product;
import lessonPack.repo.ProductJpaDAO;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceEmpl {

    private final ProductJpaDAO productJpaDAO;

    public ProductServiceEmpl(ProductJpaDAO productJpaDAO) {
        this.productJpaDAO = productJpaDAO;
    }

    @Transactional
    public List<Product> getAll(){
        return productJpaDAO.findAll();
    }

    @Transactional
    public void save(Product product){
        productJpaDAO.save(product);
    }

    @Transactional
    public List<Product> getByCost(Double start, Double end){
        return this.productJpaDAO.findAll().stream()
                .filter(product -> product.getCost() >= start && product.getCost() <= end)
                .sorted(Comparator.comparing(Product::getCost))
                .collect(Collectors.toList());
    }
}
