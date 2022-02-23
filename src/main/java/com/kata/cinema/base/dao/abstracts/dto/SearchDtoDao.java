package com.kata.cinema.base.dao.abstracts.dto;

import com.kata.cinema.base.models.dto.SearchDto;
import com.kata.cinema.base.models.dto.SearchMovieDto;

import java.util.List;
import java.util.Optional;

public interface SearchDtoDao {
    List<SearchMovieDto> getFastSearchMovieDto(String notFullName);
    Optional<SearchDto> getSearchDto(int limit);
}
