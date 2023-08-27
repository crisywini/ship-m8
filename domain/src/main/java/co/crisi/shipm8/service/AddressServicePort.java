package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IAddress;
import co.crisi.shipm8.exception.business.AddressNotFoundException;
import co.crisi.shipm8.exception.business.BusinessException;
import co.crisi.shipm8.exception.business.RepeatedAddressException;
import co.crisi.shipm8.port.api.IAddressServicePort;
import co.crisi.shipm8.port.spi.IAddressPersistencePort;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AddressServicePort implements IAddressServicePort {

    private final IAddressPersistencePort persistencePort;

    @Override
    public IAddress save(IAddress entity) {
        if (Objects.nonNull(entity.getId()) && persistencePort.existsById(entity.getId())) {
            throw new RepeatedAddressException(String.format("The address with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public IAddress getById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new AddressNotFoundException(String.format("The address %d was not found!", id)));
    }

    @Override
    public List<IAddress> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IAddress update(Long id, IAddress newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new AddressNotFoundException(String.format("The address with id %d was not found!", id));
        }
        if (!newInfo.getId().equals(id)) {
            throw new BusinessException("The body is incorrect, both ids are different!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new AddressNotFoundException(String.format("The address with id %d was not found!", id));
        }
        persistencePort.deleteById(id);
    }

}
