package co.crisi.shipm8.adapter.jpa;

import co.crisi.shipm8.domain.IProduct;
import co.crisi.shipm8.entity.jdbc.ProductJDBCEntity;
import co.crisi.shipm8.entity.jpa.ProductJPAEntity;
import co.crisi.shipm8.mapper.jpa.ProductJPAMapper;
import co.crisi.shipm8.port.spi.IProductPersistencePort;
import co.crisi.shipm8.repository.jpa.ProductJPARepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class ProductPersistenceJPAAdapter implements IProductPersistencePort {

    private final ProductJPARepository repository;

    private final ProductJPAMapper mapper;

    @Override
    public IProduct save(IProduct entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IProduct> findById(Long id) {
        ProductJPAEntity product = repository.findById(id).orElse(null);
        return Optional.ofNullable(product);
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
