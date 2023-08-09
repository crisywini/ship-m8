package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.port.spi.IDiscountPersistencePort;
import co.crisi.shipm8.repository.jdbc.DiscountJDBCRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DiscountPersistenceJDBCAdapter implements IDiscountPersistencePort {

    private final DiscountJDBCRepository repository;

    @Override
    public IDiscount save(IDiscount entity) {
        return null;
    }

    @Override
    public Optional<IDiscount> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<IDiscount> findAll() {
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
