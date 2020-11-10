package lessonPack.service;

import lessonPack.domain.Product;
import lessonPack.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product getById(Long Id){
        return this.productRepo.getById(Id);
    }

    public List<Product> getAll(){
        return this.productRepo.getAllProducts();
    }

    public List<Product> getByCost(Double start, Double end){
        return this.productRepo.getAllProducts().stream()
                .filter(product -> product.getCost() >= start && product.getCost() <= end)
                .sorted(Comparator.comparing(Product::getCost))
                .collect(Collectors.toList());
    }

    public Product save(Product product){
        return this.productRepo.save(product);
    }

    public void removeById(Long Id){
        this.productRepo.remove(Id);
    }


}
