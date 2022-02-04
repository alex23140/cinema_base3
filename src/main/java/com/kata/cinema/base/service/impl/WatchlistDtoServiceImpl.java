package com.kata.cinema.base.service.impl;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDtoDao;
import com.kata.cinema.base.dao.impl.dto.WatchlistDtoDaoImpl;
import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.abstracts.WatchlistDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistDtoServiceImpl extends AbstractServiceImpl<Long, WatchlistDto> implements WatchlistDtoService {

    @Autowired
    private final WatchlistDtoDao watchlistDtoDao;

    public WatchlistDtoServiceImpl(WatchlistDtoDaoImpl watchlistDtoDao) {
        super(watchlistDtoDao);
        this.watchlistDtoDao = watchlistDtoDao;
    }


    public List<WatchlistDto> findAllWatchlistByUserId(Long userId) {
        return watchlistDtoDao.findAllWatchlistByUserId(userId);
    }

    public WatchlistDto findWatchlistDtoById(Long id) {
        return watchlistDtoDao.findWatchlistDtoById(id);
    }
}
