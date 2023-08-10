package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import co.crisi.shipm8.repository.jdbc.AddressJDBCRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AddressPersistenceJDBCAdapter implements IAddressPersistencePort {

    private final AddressJDBCRepository repository;

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
