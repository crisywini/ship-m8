package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.AddressJDBCEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJDBCRepository extends CrudRepository<AddressJDBCEntity, Long> {

}
