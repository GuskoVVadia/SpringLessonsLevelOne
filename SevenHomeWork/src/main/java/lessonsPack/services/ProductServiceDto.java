package lessonsPack.services;

import lessonsPack.domain.Product;
import lessonsPack.dto.ProductDto;

import java.util.List;

public interface ProductServiceDto {
    List<ProductDto> getAll();
    ProductDto getById(Long id);
    ProductDto save(ProductDto productDto);

}
