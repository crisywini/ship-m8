package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.exception.BusinessException;
import co.crisi.shipm8.exception.OrderNotFoundException;
import co.crisi.shipm8.exception.RepeatedOrderException;
import co.crisi.shipm8.port.api.IOrderServicePort;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class OrderServicePort implements IOrderServicePort {

    private final IOrderPersistencePort persistencePort;

    @Override
    public IOrder save(IOrder entity) {
        if (persistencePort.existsById(entity.getId())) {
            throw new RepeatedOrderException(String.format("The order with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public Optional<IOrder> getById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<IOrder> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IOrder update(Long id, IOrder newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new OrderNotFoundException(String.format("The order with id %d was not found!", id));
        }
        if (!id.equals(newInfo.getId())) {
            throw new BusinessException("Error in the body, the ids are not equal!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new OrderNotFoundException(String.format("The order with id %d was not found!", id));
        }
        persistencePort.deleteById(id);
    }

}
