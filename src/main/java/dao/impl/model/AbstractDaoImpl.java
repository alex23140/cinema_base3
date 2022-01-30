package dao.impl.model;

import dao.abstracts.model.AbstractDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Optional;

@Repository
public abstract class AbstractDaoImpl<PK, E> implements AbstractDao<PK, E> {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        String className = getGenericName();
        return entityManager.createQuery("from " + className).getResultList();
    }

    @Override
    public void create(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public void deleteById(PK id) {
        Optional<E> entity = getById(id);
        entity.ifPresent(e -> entityManager.remove(e));
    }

    @Override
    public Optional<E> getById(PK id) {
        return Optional.of(entityManager.find(getGenericClass(), id));
    }

    @Override
    public boolean existById(PK id) {
        return getById(id).isPresent();
    }

    @SuppressWarnings("unchecked")
    private String getGenericName() {
        return ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getTypeName();
    }

    @SuppressWarnings("unchecked")
    private Class<E> getGenericClass() {
        return (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }
}
