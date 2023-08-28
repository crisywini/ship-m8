package co.crisi.shipm8.repository.jdbc;

import co.crisi.shipm8.entity.jdbc.ShopperJDBCEntity;
import java.util.Optional;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopperJDBCRepository extends CrudRepository<ShopperJDBCEntity, Long> {

    @Query("SELECT * FROM shopper WHERE shopper_id = :id")
    @Override
    Optional<ShopperJDBCEntity> findById(Long id);

}
