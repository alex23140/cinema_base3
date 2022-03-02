package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDao;
import com.kata.cinema.base.models.entity.Watchlist;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class WatchlistDaoImpl extends AbstractDaoImpl<Long, Watchlist> implements WatchlistDao {
    @PersistenceContext
    protected EntityManager entityManager;

    public Optional<Watchlist> getWatchListById(Long id) {
        try {
            return Optional.of(entityManager.createQuery("""
                            FROM Watchlist w
                            LEFT JOIN FETCH w.movies
                            LEFT JOIN FETCH w.user.role
                            WHERE w.id =: id
                            """, Watchlist.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
