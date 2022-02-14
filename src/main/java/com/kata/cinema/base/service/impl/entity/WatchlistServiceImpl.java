package com.kata.cinema.base.service.impl.entity;

import com.kata.cinema.base.dao.abstracts.model.AbstractDao;
import com.kata.cinema.base.dao.abstracts.model.WatchlistDao;
import com.kata.cinema.base.models.entity.Watchlist;
import com.kata.cinema.base.service.abstracts.entity.WatchlistService;
import com.kata.cinema.base.service.impl.entity.AbstractServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class WatchlistServiceImpl extends AbstractServiceImpl<Long, Watchlist> implements WatchlistService {

    private final WatchlistDao watchlistDao;

    protected WatchlistServiceImpl(AbstractDao<Long, Watchlist> abstractDao, WatchlistDao watchlistDao) {
        super(abstractDao);
        this.watchlistDao = watchlistDao;
    }
}