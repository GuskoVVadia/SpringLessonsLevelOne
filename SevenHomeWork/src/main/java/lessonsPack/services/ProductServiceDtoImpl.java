package lessonsPack.services;

import lessonsPack.dao.ProductDao;
import lessonsPack.domain.Product;
import lessonsPack.dto.ProductDto;
import lessonsPack.mapper.ProductMapper;

import java.util.List;

public class ProductServiceDtoImpl implements ProductServiceDto{

    private final ProductMapper productMapper = ProductMapper.MAPPER;
    private final ProductDao productDao;

    public ProductServiceDtoImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<ProductDto> getAll() {
        return this.productMapper.fromProductList(this.productDao.findAll());
    }

    @Override
    public ProductDto getById(Long id) {
        return this.productMapper.fromProduct(this.productDao.getOne(id));
    }

    @Override
    public ProductDto save(ProductDto productDto) {
        Product product = this.productMapper.toProduct(productDto);
        Product saveProduct = this.productDao.save(product);
        return this.productMapper.fromProduct(saveProduct);
    }
}
