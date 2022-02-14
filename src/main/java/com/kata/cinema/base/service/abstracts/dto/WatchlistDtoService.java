package com.kata.cinema.base.service.abstracts.dto;

import com.kata.cinema.base.models.dto.WatchlistDto;

import java.util.List;
import java.util.Optional;

public interface WatchlistDtoService {

    List<WatchlistDto> findAllWatchlistByUserId(Long userId);

    Optional<WatchlistDto> findWatchlistDtoById(Long id);
}
