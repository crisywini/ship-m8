package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.ProductJDBCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJDBCRepository extends CrudRepository<ProductJDBCEntity, Long> {

}
