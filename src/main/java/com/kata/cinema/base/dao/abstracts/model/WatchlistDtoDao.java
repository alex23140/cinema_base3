package com.kata.cinema.base.dao.abstracts.model;

import com.kata.cinema.base.models.dto.WatchlistDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WatchlistDtoDao {

    List<WatchlistDto> findAllWatchlistByUserId(Long userId);

    Optional<WatchlistDto> findWatchlistDtoById(Long id);
}
