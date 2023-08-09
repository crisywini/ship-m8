package co.crisi.shipm8.port.spi;

import java.util.List;
import java.util.Optional;

public interface PersistencePort<T, ID> {

    T save(T entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    void deleteById(ID id);

}
