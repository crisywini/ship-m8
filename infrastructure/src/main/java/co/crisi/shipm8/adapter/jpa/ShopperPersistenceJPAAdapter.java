package co.crisi.shipm8.adapter.jpa;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.domain.IShopper;
import co.crisi.shipm8.mapper.jpa.ProductJPAMapper;
import co.crisi.shipm8.mapper.jpa.ShopperJPAMapper;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.port.spi.IShopperPersistencePort;
import co.crisi.shipm8.repository.jpa.ProductJPARepository;
import co.crisi.shipm8.repository.jpa.ShopperJPARepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ShopperPersistenceJPAAdapter implements IShopperPersistencePort {

    private final ShopperJPARepository repository;

    private final ShopperJPAMapper mapper = Mappers.getMapper(ShopperJPAMapper.class);

    @Override
    public IShopper save(IShopper entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IShopper> findById(Long id) {
        IShopper shopper = repository.findById(id).orElse(null);
        return Optional.ofNullable(shopper);
    }

    @Override
    public List<IShopper> findAll() {
        return List.copyOf((Collection<? extends IShopper>) repository.findAll());
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
