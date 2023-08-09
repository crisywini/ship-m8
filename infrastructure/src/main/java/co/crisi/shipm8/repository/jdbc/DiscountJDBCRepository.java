package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.DiscountJDBCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountJDBCRepository extends CrudRepository<DiscountJDBCEntity, Long> {

}
