/**
 * Класс представляет собой хранилище единиц информации из класса Product
 * Предоставляет не является потокобезопасным.
 */
package lessonPack.repository;

import lessonPack.domain.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProductRepo {

    private Map<Long, Product> mapProducts = new HashMap<>();
    private long ind;

    public Product getById(long id){
        return mapProducts.get(id);
    }

    public List<Product> getAll(){
        return new ArrayList<>(mapProducts.values());
    }

    public Product save(Product product){
        if (product.getId() == null){
            product.setId(++ind);
        }
        mapProducts.put(product.getId(), product);
        return product;
    }

    public void remove(long id){
        mapProducts.remove(id);
    }
}
