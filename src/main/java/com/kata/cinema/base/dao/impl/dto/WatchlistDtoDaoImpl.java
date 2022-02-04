package com.kata.cinema.base.dao.impl.dto;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDtoDao;
import com.kata.cinema.base.dao.impl.model.AbstractDaoImpl;
import com.kata.cinema.base.models.dto.WatchlistDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WatchlistDtoDaoImpl extends AbstractDaoImpl<Long, WatchlistDto> implements WatchlistDtoDao {

    @PersistenceContext
    private EntityManager entityManager;

    public List<WatchlistDto> findAllWatchlistByUserId(Long userId){
        return  entityManager.createQuery("SELECT NEW com.kata.cinema.base.models.dto.WatchlistDto (" +
                "w.id," +
                "w.category," +
                "w.privacy," +
                "w.name," +
                "w.description," +
                "w.user.id) FROM Watchlist w where w.user.id = : userId ")
                .setParameter("userId", userId).getResultList();
    }

    public WatchlistDto findWatchlistDtoById (Long id){
        WatchlistDto watchlistDto =(WatchlistDto) entityManager.createQuery( "SELECT NEW com.kata.cinema.base.models.dto.WatchlistDto (" +
                        "w.id," +
                        "w.category," +
                        "w.privacy," +
                        "w.name," +
                        "w.description," +
                        "w.user.id) FROM Watchlist w where w.id = : id ")
                .setParameter("id", id).getSingleResult();
        return watchlistDto;
    }
}
