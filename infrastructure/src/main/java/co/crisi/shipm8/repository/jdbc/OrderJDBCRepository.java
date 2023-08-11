package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.OrderJDBCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJDBCRepository extends CrudRepository<OrderJDBCEntity, Long> {

}
