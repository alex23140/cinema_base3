package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.entity.Watchlist;

import java.util.Optional;


public interface WatchlistDao extends AbstractDao<Long, Watchlist> {
    Optional<Watchlist> getWatchListById(Long id);
}
