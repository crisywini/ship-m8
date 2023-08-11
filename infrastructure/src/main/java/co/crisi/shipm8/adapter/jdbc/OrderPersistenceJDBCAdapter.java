package co.crisi.shipm8.adapter.jdbc;

import co.crisi.shipm8.domain.IOrder;
import co.crisi.shipm8.entity.OrderJDBCEntity;
import co.crisi.shipm8.mapper.OrderMapper;
import co.crisi.shipm8.port.spi.IOrderPersistencePort;
import co.crisi.shipm8.repository.jdbc.OrderJDBCRepository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Repository;

@Repositoryash
@RequiredArgsConstructor
public class OrderPersistenceJDBCAdapter implements IOrderPersistencePort {

    private final OrderJDBCRepository repository;

    private final OrderMapper mapper = Mappers.getMapper(OrderMapper.class);

    @Override
    public IOrder save(IOrder entity) {
        return repository.save(mapper.map(entity));
    }

    @Override
    public Optional<IOrder> findById(Long id) {
        Optional<OrderJDBCEntity> order = repository.findById(id);
        IOrder found = order.orElse(null);
        return Optional.ofNullable(found);
    }

    @Override
    public List<IOrder> findAll() {
        return new ArrayList<>((Collection<? extends IOrder>) repository.findAll());
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
