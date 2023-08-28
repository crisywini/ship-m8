package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.mapper.jdbc.AddressJDBCMapper;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import co.crisi.shipm8.repository.jdbc.AddressJDBCRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressPersistenceJDBCAdapter implements IAddressPersistencePort {

    private final AddressJDBCRepository repository;

    private final AddressJDBCMapper mapper = Mappers.getMapper(AddressJDBCMapper.class);

    @Override
    public IAddress save(IAddress entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IAddress> findById(Long id) {
        IAddress address = repository.findById(id).orElse(null);
        return Optional.ofNullable(address);
    }

    @Override
    public List<IAddress> findAll() {
        return List.copyOf(new ArrayList<>((Collection<? extends IAddress>) repository.findAll()));
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

}
