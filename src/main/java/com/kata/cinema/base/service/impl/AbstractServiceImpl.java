package com.kata.cinema.base.service.impl;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import org.springframework.transaction.annotation.Transactional;
import com.kata.cinema.base.service.abstracts.AbstractService;

import java.util.List;
import java.util.Optional;

public abstract class AbstractServiceImpl<PK, E> implements AbstractService<PK, E> {

    private final AbstractDao<PK, E> abstractDao;

    protected AbstractServiceImpl(AbstractDao<PK, E> abstractDao) {
        this.abstractDao = abstractDao;
    }

    @Override
    public List<E> getAll() {
        return abstractDao.getAll();
    }

    @Override
    @Transactional
    public void create(E entity) {
        abstractDao.create(entity);
    }

    @Override
    @Transactional
    public void update(E entity) {
        abstractDao.update(entity);
    }

    @Override
    @Transactional
    public void delete(E entity) {
        abstractDao.delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(PK id) {
        abstractDao.deleteById(id);
    }

    @Override
    public Optional<E> getById(PK id) {
        return abstractDao.getById(id);
    }

    @Override
    public boolean isExistById(PK id) {
        return abstractDao.isExistById(id);
    }
}
