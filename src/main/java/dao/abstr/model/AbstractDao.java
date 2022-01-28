package dao.abstr.model;

import java.util.List;
import java.util.Optional;

public interface AbstractDao<PK, E> {
    List<E> getAll();

    void create(E entity);

    void update(E entity);

    void delete(E entity);

    void deleteById(PK id);

    Optional<E> getById(PK id);

    boolean existById(PK id);
}
