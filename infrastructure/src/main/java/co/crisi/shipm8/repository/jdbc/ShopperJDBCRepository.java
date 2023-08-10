package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.ShopperJDBCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperJDBCRepository extends CrudRepository<ShopperJDBCEntity, Long> {

}
