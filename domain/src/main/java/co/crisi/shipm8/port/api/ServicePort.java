package co.crisi.shipm8.port.api;

import java.util.List;
import java.util.Optional;

public interface ServicePort<T, ID> {

    T save(T entity);

    Optional<T> getById(ID id);

    List<T> getAll();

    T update(ID id, T newInfo);

    void deleteById(ID id);

}
