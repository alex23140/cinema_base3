package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.WatchlistDtoDao;
import com.kata.cinema.base.models.dto.WatchlistDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Repository
public class WatchlistDtoDaoImpl implements WatchlistDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<WatchlistDto> findAllWatchlistByUserId(Long userId) {
        return entityManager.createQuery("""
                        SELECT NEW com.kata.cinema.base.models.dto.WatchlistDto(
                        w.id,
                        w.category,
                        w.privacy,
                        w.name,
                        w.description,
                        w.user.id)
                        FROM Watchlist w where w.user.id = :userId""", WatchlistDto.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public Optional<WatchlistDto> findWatchlistDtoById(Long id) {
        try {
            return Optional.of(entityManager.createQuery("""
                            SELECT NEW com.kata.cinema.base.models.dto.WatchlistDto(
                            w.id,
                            w.category,
                            w.privacy,
                            w.name,
                            w.description,
                            w.user.id)
                            FROM Watchlist w where w.id = :id""", WatchlistDto.class)
                    .setParameter("id", id)
                    .getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }
}
