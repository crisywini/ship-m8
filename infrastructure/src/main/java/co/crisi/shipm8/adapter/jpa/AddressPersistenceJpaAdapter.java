package co.crisi.shipm8.adapter.jpa;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressPersistenceJpaAdapter implements IAddressPersistencePort {

    @Override
    public IAddress save(IAddress entity) {
        return null;
    }

    @Override
    public Optional<IAddress> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public List<IAddress> findAll() {
        return null;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

}
