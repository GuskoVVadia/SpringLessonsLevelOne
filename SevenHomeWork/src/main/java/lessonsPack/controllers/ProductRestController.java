package lessonsPack.controllers;

import lessonsPack.domain.Product;
import lessonsPack.exceptions.EntityNotFoundException;
import lessonsPack.exceptions.EntityNotFoundResponse;
import lessonsPack.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/products")
@RestController
public class ProductRestController {

    private final ProductService productService;

    @Autowired
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return this.productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        checkById(id);
        return this.productService.getById(id);
    }

    @PostMapping("/")
    public Product addProduct(@RequestBody Product product){
        return this.productService.save(product);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product product, @PathVariable(name = "productId") Long id){
        product.setId(id);
        return this.productService.save(product);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id){
        checkById(id);
        this.productService.deleteById(id);
    }

    private void checkById(@PathVariable Long id) {
        if(!this.productService.contains(id)){
            throw new EntityNotFoundException("Product", id, "Product not found");
        }
    }

    @ExceptionHandler
    public ResponseEntity<EntityNotFoundResponse> handleException(EntityNotFoundException ex){
        EntityNotFoundResponse response = new EntityNotFoundResponse();
        response.setEntityName(ex.getEntityName());
        response.setEntityId(ex.getEntityId());
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
