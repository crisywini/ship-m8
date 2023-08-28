package co.crisi.shipm8.adapter.jpa;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.jpa.OrderJPAEntity;
import co.crisi.shipm8.mapper.jpa.OrderJPAMapper;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import co.crisi.shipm8.repository.jpa.OrderJPARepository;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderPersistenceJPAAdapter implements IOrderPersistencePort {

    private final OrderJPARepository repository;

    private final OrderJPAMapper mapper = Mappers.getMapper(OrderJPAMapper.class);

    @Override
    public IOrder save(IOrder entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IOrder> findById(Long id) {
        OrderJPAEntity order = repository.findById(id).orElse(null);
        return Optional.ofNullable(order);
    }

    @Override
    public List<IOrder> findAll() {
        return List.copyOf((Collection<? extends IOrder>) repository.findAll());
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
