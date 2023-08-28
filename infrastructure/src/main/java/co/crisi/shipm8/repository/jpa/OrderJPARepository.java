package co.crisi.shipm8.repository.jpa;

import co.crisi.shipm8.entity.jpa.OrderJPAEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderJPARepository extends CrudRepository<OrderJPAEntity, Long> {

}
