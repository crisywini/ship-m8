package co.crisi.shipm8.repository.jpa;

import co.crisi.shipm8.entity.jpa.AddressJPAEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressJPARepository extends CrudRepository<AddressJPAEntity, Long> {

}
