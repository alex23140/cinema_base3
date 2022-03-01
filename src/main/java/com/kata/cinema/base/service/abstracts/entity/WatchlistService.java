package com.kata.cinema.base.service.abstracts.entity;


import com.kata.cinema.base.models.entity.Watchlist;
import com.kata.cinema.base.service.abstracts.entity.AbstractService;

import java.util.Optional;

public interface WatchlistService extends AbstractService<Long, Watchlist> {
    Optional<Watchlist> getWatchListById(Long id);
}
