package com.kata.cinema.base.dao.impl.model;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDao;
import com.kata.cinema.base.models.entity.Watchlist;
import org.springframework.stereotype.Repository;

@Repository
public class WatchlistDaoImpl extends AbstractDaoImpl<Long, Watchlist> implements WatchlistDao {

}
