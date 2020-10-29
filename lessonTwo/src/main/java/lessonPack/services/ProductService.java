/**
 * Класс предоставляет методы для работы с хранилищем( т.е. объектом из репозитория)
 * Класс не является потокобезопасным.
 * Класс служит для внедрения необходимой дополнительной логики для работы с классами из репозитория.
 */
package lessonPack.services;

import lessonPack.domain.Product;
import lessonPack.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepo productRepo;

    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> getAll(){
        return this.productRepo.getAll();
    }

    public Product save(Product product){
        return this.productRepo.save(product);
    }

    public void removeById(long id){
        this.productRepo.remove(id);
    }

    public Product getById(Long id){
        return this.productRepo.getById(id);
    }
}
