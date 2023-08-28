package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.jdbc.AddressJDBCEntity;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJDBCRepository extends CrudRepository<AddressJDBCEntity, Long> {

    @Query("SELECT * FROM address WHERE address_id = :id")
    @Override
    Optional<AddressJDBCEntity> findById(Long id);

}
