package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.exception.business.BusinessException;
import co.crisi.shipm8.exception.business.ProductNotFoundException;
import co.crisi.shipm8.exception.business.RepeatedProductException;
import co.crisi.shipm8.port.api.IProductServicePort;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ProductServicePort implements IProductServicePort {

    private final IProductPersistencePort persistencePort;

    @Override
    public IProduct save(IProduct entity) {
        if (persistencePort.existsById(entity.getId())) {
            throw new RepeatedProductException(String.format("The product with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public Optional<IProduct> getById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<IProduct> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IProduct update(Long id, IProduct newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new ProductNotFoundException(String.format("The product with id %d was not found!", id));
        }
        if (!id.equals(newInfo.getId())) {
            throw new BusinessException("Error in the body, the ids of the products are not equal!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new ProductNotFoundException(String.format("The product with id %d was not found!", id));
        }
        persistencePort.deleteById(id);
    }

}
