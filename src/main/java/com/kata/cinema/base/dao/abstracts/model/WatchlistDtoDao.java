package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.dto.WatchlistDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistDtoDao {

    public List<WatchlistDto> findAllWatchlistByUserId(Long userId);

    public WatchlistDto findWatchlistDtoById(Long id);
}
