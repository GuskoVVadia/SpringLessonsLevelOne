package lessonPack.repository;

import lessonPack.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductJpaDAO extends JpaRepository<Product, Long> {

}
