package com.kata.cinema.base.mapper;

import com.kata.cinema.base.models.dto.WatchlistDto;
import com.kata.cinema.base.models.entity.Watchlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WatchlistMapper extends DtoMapper<WatchlistDto, Watchlist>, EntityMapper<WatchlistDto, Watchlist> {
}
