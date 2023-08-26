package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.exception.business.BusinessException;
import co.crisi.shipm8.exception.business.DiscountNotFoundException;
import co.crisi.shipm8.exception.business.RepeatedDiscountException;
import co.crisi.shipm8.port.api.IDiscountServicePort;
import co.crisi.shipm8.port.spi.IDiscountPersistencePort;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DiscountServicePort implements IDiscountServicePort {

    private final IDiscountPersistencePort persistencePort;


    @Override
    public IDiscount save(IDiscount entity) {
        if (persistencePort.existsById(entity.getId())) {
            throw new RepeatedDiscountException(
                    String.format("The discount with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public IDiscount getById(Long id) {
        return persistencePort.findById(id)
                .orElseThrow(() -> new DiscountNotFoundException(String.format("The id %d was not found!", id)));
    }

    @Override
    public List<IDiscount> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IDiscount update(Long id, IDiscount newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new DiscountNotFoundException(String.format("The discount with id %d was not found!", id));
        }
        if (!id.equals(newInfo.getId())) {
            throw new BusinessException("The body is not correct, ids of the addresses are different!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new DiscountNotFoundException(String.format("The discount with id %d was not found", id));
        }
        persistencePort.deleteById(id);
    }

}
