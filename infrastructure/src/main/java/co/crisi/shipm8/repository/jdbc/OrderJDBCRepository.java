package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.jdbc.OrderJDBCEntity;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderJDBCRepository extends CrudRepository<OrderJDBCEntity, Long> {

    @Query("SELECT * FROM order WHERE order_id = :id")
    @Override
    Optional<OrderJDBCEntity> findById(Long id);

}
