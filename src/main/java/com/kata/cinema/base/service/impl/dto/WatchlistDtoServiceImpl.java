package com.kata.cinema.base.service.impl.dto;

import com.kata.cinema.base.dao.abstracts.dto.WatchlistDtoDao;
import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.service.abstracts.dto.WatchlistDtoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<WatchlistDto> findWatchlistDtoById(Long id) {
        return watchlistDtoDao.findWatchlistDtoById(id);
    }
}
