package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jdbc.ProductJDBCEntity;
import co.crisi.shipm8.mapper.jdbc.ProductJDBCMapper;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.repository.jdbc.ProductJDBCRepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductPersistenceJDBCAdapter implements IProductPersistencePort {

    private final ProductJDBCRepository repository;

    private final ProductJDBCMapper mapper = Mappers.getMapper(ProductJDBCMapper.class);

    @Override
    public IProduct save(IProduct entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IProduct> findById(Long id) {
        Optional<ProductJDBCEntity> product = repository.findById(id);
        IProduct found = product.orElse(null);
        return Optional.ofNullable(found);
    }

    @Override
    public List<IProduct> findAll() {
        return List.copyOf((Collection<? extends IProduct>) repository.findAll());
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
