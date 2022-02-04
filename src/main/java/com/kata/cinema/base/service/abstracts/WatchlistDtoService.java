package com.kata.cinema.base.service.abstracts;

import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.models.entity.User;
import com.kata.cinema.base.service.impl.WatchlistDtoServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WatchlistDtoService extends AbstractService <Long, WatchlistDto>{



    public List<WatchlistDto> findAllWatchlistByUserId(Long userId);


    public WatchlistDto findWatchlistDtoById (Long id);
}
