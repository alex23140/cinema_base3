package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.WatchlistDto;

import java.util.List;

public interface WatchlistDtoService {

    List<WatchlistDto> findAllWatchlistByUserId(Long userId);

    WatchlistDto findWatchlistDtoById(Long id);
}
