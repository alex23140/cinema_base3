package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.WatchlistDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WatchlistDtoDao {

    List<WatchlistDto> findAllWatchlistByUserId(Long userId);

    WatchlistDto findWatchlistDtoById(Long id);
}
