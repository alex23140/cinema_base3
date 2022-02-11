package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.model.WatchlistDtoDao;
import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.abstracts.dto.WatchlistDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WatchlistDtoServiceImpl implements WatchlistDtoService {

    private final WatchlistDtoDao watchlistDtoDao;

    @Autowired
    public WatchlistDtoServiceImpl(WatchlistDtoDao watchlistDtoDao) {
        this.watchlistDtoDao = watchlistDtoDao;
    }

    public List<WatchlistDto> findAllWatchlistByUserId(Long userId) {
        return watchlistDtoDao.findAllWatchlistByUserId(userId);
    }

    public WatchlistDto findWatchlistDtoById(Long id) {
        return watchlistDtoDao.findWatchlistDtoById(id);
    }
}
