package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDao;
import com.kata.cinema.base.models.entity.Watchlist;
import com.kata.cinema.base.service.abstracts.entity.WatchlistService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class WatchlistServiceImpl extends AbstractServiceImpl<Long, Watchlist> implements WatchlistService {

    private final WatchlistDao watchlistDao;

    protected WatchlistServiceImpl(WatchlistDao watchlistDao) {
        super(watchlistDao);
        this.watchlistDao = watchlistDao;
    }

    @Override
    public Optional<Watchlist> getWatchListById(Long id) {
        return watchlistDao.getWatchListById(id);
    }
}
