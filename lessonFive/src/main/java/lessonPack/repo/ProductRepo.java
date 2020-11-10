package lessonPack.repo;

import lessonPack.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo {

    private final Map<Long, Product> productMap = new HashMap<>();
    private Long idn = 0L;

    {
        productMap.put(idn, new Product(idn, "Milk", 25.0));
        productMap.put(++idn, new Product(idn, "Bread", 15.5));
        productMap.put(++idn, new Product(idn, "Cheese", 30.0));
        productMap.put(++idn, new Product(idn, "Oil", 20.0));
        productMap.put(++idn, new Product(idn, "Meat", 35.0));
    }

    public Product getById(Long id){
        return this.productMap.get(id);
    }

    public List<Product> getAllProducts(){
        return new ArrayList<>(this.productMap.values());
    }

    public Product save(Product product){
        if (product.getId() == null || product.getId() < 0) {
            product.setId(++idn);
        }
        productMap.put(idn, product);
        return product;
    }

    public void remove(Long id){
        this.productMap.remove(id);
    }

}
