package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IDiscount;
import co.crisi.shipm8.mapper.jdbc.DiscountJDBCMapper;
import co.crisi.shipm8.port.spi.IDiscountPersistencePort;
import co.crisi.shipm8.repository.jdbc.DiscountJDBCRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DiscountPersistenceJDBCAdapter implements IDiscountPersistencePort {

    private final DiscountJDBCRepository repository;

    private final DiscountJDBCMapper mapper = Mappers.getMapper(DiscountJDBCMapper.class);

    @Override
    public IDiscount save(IDiscount entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IDiscount> findById(Long id) {
        var discount = repository.findById(id);
        IDiscount out = discount.orElse(null);
        return Optional.ofNullable(out);
    }

    @Override
    public List<IDiscount> findAll() {
        var discounts = repository.findAll();
        List<IDiscount> iDiscounts = new ArrayList<>((Collection<? extends IDiscount>) discounts);
        return List.copyOf(iDiscounts);
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
