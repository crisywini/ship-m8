package co.crisi.shipm8.repository.jpa;

import co.crisi.shipm8.entity.jpa.ProductJPAEntity;
import org.springframework.data.repository.CrudRepository;

public interface ProductJPARepository extends CrudRepository<ProductJPAEntity, Long> {

}
