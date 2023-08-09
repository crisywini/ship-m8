package co.crisi.shipm8.service;

import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.exception.BusinessException;
import co.crisi.shipm8.exception.RepeatedProductException;
import co.crisi.shipm8.exception.RepeatedShopperException;
import co.crisi.shipm8.exception.ShopperNotFoundException;
import co.crisi.shipm8.port.api.IShopperServicePort;
import co.crisi.shipm8.port.spi.IShopperPersistencePort;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ShopperServicePort implements IShopperServicePort {

    private final IShopperPersistencePort persistencePort;

    @Override
    public IShopper save(IShopper entity) {
        if (!persistencePort.existsById(entity.getId())) {
            throw new RepeatedProductException(String.format("The product with id %d already exists!", entity.getId()));
        }
        return persistencePort.save(entity);
    }

    @Override
    public Optional<IShopper> getById(Long id) {
        return persistencePort.findById(id);
    }

    @Override
    public List<IShopper> getAll() {
        return persistencePort.findAll();
    }

    @Override
    public IShopper update(Long id, IShopper newInfo) {
        if (!persistencePort.existsById(id)) {
            throw new ShopperNotFoundException(String.format("The shopper with id %d was not found!", id));
        }
        if (!id.equals(newInfo.getId())) {
            throw new BusinessException("The body is incorrect, both shopper ids are not equal!");
        }
        return save(newInfo);
    }

    @Override
    public void deleteById(Long id) {
        if (!persistencePort.existsById(id)) {
            throw new ShopperNotFoundException(String.format("The shopper with id %d was not found!", id));
        }
        persistencePort.deleteById(id);
    }

}
