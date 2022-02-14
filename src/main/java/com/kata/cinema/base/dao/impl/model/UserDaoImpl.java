package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.UserDao;
import com.kata.cinema.base.models.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<Long, User> implements UserDao {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Optional<User> getUserByEmail(String email) {
        try {
            return Optional.of(entityManager.createQuery("FROM User u JOIN FETCH u.role WHERE u.email =: email", User.class)
                    .setParameter("email", email)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
